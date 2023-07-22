<?php

namespace App\Http\Controllers;

use App\Models\Event;
use App\Models\Group;
use App\Models\Room;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Http\Request;
use Illuminate\Support\Carbon;
use League\Csv\Writer;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\DB;

class EventController extends Controller
{

    public function index(Request $request)
    {
        $room_id = $request->query('classId');
        $day = $request->query('selectedDay');

        $events = Event::with(["room", "supervisor", "courses", "typology"]);

        if (!is_null($room_id)) {
            $events = Event::with(["room", "supervisor", "courses", "typology"])->where('room_id', $room_id);
        }

        if (!is_null($day)) {
            $start_of_week = Carbon::parse($day)->startOfWeek(Carbon::MONDAY);
            $end_of_week = Carbon::parse($day)->endOfWeek(Carbon::SUNDAY);

            $events = $events->whereDate('date', '>=', $start_of_week->format('Y-m-d'))
                             ->whereDate('date', '<=', $end_of_week->format('Y-m-d'));
        }

        return $events->get();
    }

    public function show(string $id)
    {
        $event = Event::with(["room", "supervisor", 'courses', "typology"])->findOrFail($id);
        return $event;
    }

    function getWeeklyEventsByCourseId(Request $request) {

        $course_id = $request->query('courseId');
        $day = $request->query('selectedDay') ?? now();

        $start_of_week = Carbon::parse($day)->startOfWeek(Carbon::MONDAY);
        $end_of_week = Carbon::parse($day)->endOfWeek(Carbon::SUNDAY);

        $events = Event::with(["room", "supervisor", "courses", "typology"])
            ->whereDate('date', ">=", $start_of_week->format('Y-m-d'))
            ->whereDate('date', "<=", $end_of_week->format('Y-m-d'))
            ->whereHas('courses', function (Builder $query) use ($course_id) {
                $query->where('course_id', '=', $course_id);
            })->get();

        return response()->json($events);
    }

    public function store(Request $request)
    {

        $validated = $request->validate([

            'name' => 'required|string',
            'description' => 'required|string|nullable',
            'date' => 'required|date',
            'start_time' => 'required|date_format:H:i',
            'end_time' => 'required|date_format:H:i',
            'typology_id' => 'required|integer|exists:typologies,id',
            'supervisor_id' => 'required|integer|exists:supervisors,id',
            'room_id' => 'required|integer|exists:rooms,id',

        ]);

        return Event::create($validated); //May return the entire event
    }

    public function update(Request $request, $id)
    {

        $event = Event::findOrFail($id);

        if($request->has("name")){
            $event->name = $request->get("name");
        }
        if($request->has("description")){
            $event->description = $request->get("description");
        }
        if($request->has("date")){
            $event->date = $request->get("date");
        }
        if($request->has("start_time")){
            $event->start_time = $request->get("start_time");
        }
        if($request->has("end_time")){
            $event->end_time = $request->get("end_time");
        }
        if($request->has("typology_id")){
            $event->typology_id = $request->get("typology_id");
        }
        if($request->has("supervisor_id")){
            $event->supervisor_id = $request->get("supervisor_id");
        }
        if($request->has("room_id")){
            $event->room_id = $request->get("room_id");
        }

        return $event->save(); //May return the entire event
    }

    public function exportToCSV()
    {

        $events = Event::with(['room', 'supervisor', 'courses', 'typology'])->get()->toArray();

        $csvHeader = [
            'id',
            'date',
            'start_time',
            'end_time',
            'name',
            'description',
            'typology_id',
            'typology_name',
            'supervisor_id',
            'supervisor_name',
            'supervisor_email',
            'room_id',
            'room_name',
            'course_id',
            'course_name'
        ];

        $csv = Writer::createFromString('');
        $csv->insertOne($csvHeader);

        foreach ($events as $event) {
            foreach($event['courses'] as $course) {
                $csv->insertOne([
                    $event['id'],
                    $event['date'],
                    $event['start_time'],
                    $event['end_time'],
                    $event['name'],
                    $event['description'],
                    $event['typology_id'],
                    $event['typology']['name'],
                    $event['supervisor_id'],
                    $event['supervisor']['name'],
                    $event['supervisor']['email'],
                    $event['room_id'],
                    $event['room']['name'],
                    $course['id'],
                    $course['name']
                ]);
            }
        }

        $csvPath = 'exports/events.csv';
        Storage::put($csvPath, (string) $csv);

        $headers = [
            'Content-Type' => 'text/csv',
            'Content-Disposition' => 'attachment; filename="events.csv"',
        ];

        return response()->download(storage_path("app/{$csvPath}"), 'events.csv', $headers);
    }


    function getNextEventsByGroupId(Request $request) {

        $group_id = $request->query('groupId');
        $now = Carbon::now();
        $to = Carbon::now()->addHours(3);

        $rooms = Room::where('group_id', "=", $group_id)->get()->pluck('id');

        $events = Event::with(["room", "supervisor", "courses", "typology"])
            ->whereIn('room_id', $rooms)
            ->whereTime('start_time', '>=', $now->format('H:i:s'))
            ->whereTime('start_time', '<=', $to->format('H:i:s'))
            ->whereDate('date', "=", $now->format('Y-m-d'))
            ->get();

        return response()->json($events);
    }

    public function destroy(string $id)
    {
        $room = Event::findOrFail($id);

        $room->delete();
    }

}
