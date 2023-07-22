<?php

namespace App\Http\Controllers;

use App\Models\Group;
use App\Models\Room;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Http\Request;
use Illuminate\Support\Carbon;
use Illuminate\Support\Facades\Validator;

class RoomController extends Controller
{
    public function index(Request $request) {
        $group_id = $request->query('groupId', 0);

        if ($group_id > 0) {
            $group = Group::findOrFail($group_id);
            $rooms = Room::whereBelongsTo($group)->get();
        } else {
            $rooms = Room::all();
        }

        return $rooms;
    }

    public function show(string $id)
    {
        return Room::findOrFail($id);
    }

    public function store(Request $request) {

        $validated = $request->validate([

            'name' => 'required|string',
            'capacity' => 'required|integer',
            'description' => 'required|string|nullable',
            'link' => 'required|string|nullable',
            'electricalOutlets' => 'required|integer',
            'ethernetPorts' => 'required|integer',
            'location_id' => 'required|integer|exists:locations,id',
            'supervisor_id' => 'required|integer|exists:supervisors,id',
            'group_id' => 'required|integer|exists:groups,id'

        ]);

        return Room::create($validated);
    }

    public function update(Request $request, $id) {

        $room = Room::findOrFail($id);

        if($request->has("name")){
            $room->name = $request->get("name");
        }
        if($request->has("capacity")){
            $room->capacity = $request->get("capacity");
        }
        if($request->has("description")){
            $room->description = $request->get("description");
        }
        if($request->has("link")){
            $room->link = $request->get("link");
        }
        if($request->has("electricalOutlets")){
            $room->electricalOutlets = $request->get("electricalOutlets");
        }
        if($request->has("ethernetPorts")){
            $room->ethernetPorts = $request->get("ethernetPorts");
        }
        if($request->has("location_id")){
            $room->location_id = $request->get("location_id");
        }
        if($request->has("supervisor_id")){
            $room->supervisor_id = $request->get("supervisor_id");
        }
        if($request->has("group_id")){
            $room->group_id = $request->get("group_id");
        }

        return $room->save();
    }

    public function destroy(string $id)
    {
        $room = Room::findOrFail($id);

        $room->delete();
    }


    public function getRoomEventsByDateAndGroup(Request $request) {

        $group_id = $request->query('groupId');
        $selected_day = Carbon::parse($request->query('selectedDay'))->format('Y-m-d');

        $rooms = Room::with(['events' => function($query) use ($selected_day) {
                $query->whereDate('date', $selected_day);
            }, 'events.room', 'events.supervisor', 'events.courses', 'events.typology'])
            ->where('group_id', "=", $group_id)
            ->whereHas('events', function (Builder $query) use ($selected_day) {
                $query->where('date', '=', $selected_day);
            })
            ->get();

        return response()->json($rooms);

    }
}
