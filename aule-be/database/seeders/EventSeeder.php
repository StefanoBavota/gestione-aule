<?php

namespace Database\Seeders;

use App\Models\Event;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class EventSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {

        $events = [

            [
                "date" => "2023-07-04",
                "start_time" => "14:30",
                "end_time" => "16:30",
                "name" => "E001",
                "description" => "Esame Basi di dati laboratorio",
                "typology_id" => 2,
                "supervisor_id" => 3,
                "room_id" => 5,
            ],

            [
                "date" => "2023-07-05",
                "start_time" => "14:30",
                "end_time" => "16:30",
                "name" => "E002",
                "description" => "Esame Basi di dati laboratorio",
                "typology_id" => 2,
                "supervisor_id" => 3,
                "room_id" => 5,
            ],

            [
                "date" => "2023-07-20",
                "start_time" => "8:30",
                "end_time" => "10:30",
                "name" => "E004",
                "description" => "Esame laboratorio di algoritmica avanzata",
                "typology_id" => 2,
                "supervisor_id" => 3,
                "room_id" => 10,
            ],

            [
                "date" => "2023-07-25",
                "start_time" => "18:00",
                "end_time" => "18:30",
                "name" => "E005",
                "description" => "Esame Web engineering",
                "typology_id" => 2,
                "supervisor_id" => 2,
                "room_id" => 5,
            ],

            [
                "date" => "2023-06-27",
                "start_time" => "10:00",
                "end_time" => "13:30",
                "name" => "S009",
                "description" => "Seminario CyberSecurity",
                "typology_id" => 4,
                "supervisor_id" => 1,
                "room_id" => 8,
            ],

            [
                "date" => "2023-07-31",
                "start_time" => "18:00",
                "end_time" => "18:30",
                "name" => "S014",
                "description" => "Seminario sensibilizzazione igiene personale",
                "typology_id" => 3,
                "supervisor_id" => 2,
                "room_id" => 11,
            ],

            [
                "date" => "2023-08-2",
                "start_time" => "9:00",
                "end_time" => "10:30",
                "name" => "I2I007",
                "description" => "Seminario ingegneria del software",
                "typology_id" => 4,
                "supervisor_id" => 2,
                "room_id" => 4,
            ],

            [
                "date" => "2023-08-02",
                "start_time" => "10:00",
                "end_time" => "12:30",
                "name" => "E013",
                "description" => "Esame Parziale Matematica discreta 1 e 2",
                "typology_id" => 4,
                "supervisor_id" => 2,
                "room_id" => 8,
            ],

            [
                "date" => "2023-08-03",
                "start_time" => "10:00",
                "end_time" => "13:30",
                "name" => "E016",
                "description" => "Esame Ottimizzazione combinatoria",
                "typology_id" => 2,
                "supervisor_id" => 2,
                "room_id" => 16,
            ],

            [
                "date" => "2023-08-04",
                "start_time" => "14:30",
                "end_time" => "17:30",
                "name" => "L010",
                "description" => "Lezione Analisi",
                "typology_id" => 3,
                "supervisor_id" => 1,
                "room_id" => 8,
            ]

        ];

        foreach ($events as $event) {
            Event::create($event);
        }

        DB::table('course_event')->insert([
            ["course_id" => 1, 'event_id' => 1],
            ["course_id" => 2, 'event_id' => 1],
            ["course_id" => 3, 'event_id' => 1],
            ["course_id" => 4, 'event_id' => 1],
            ["course_id" => 5, 'event_id' => 1],
            ["course_id" => 1, 'event_id' => 6],
            ["course_id" => 1, 'event_id' => 7],
            ["course_id" => 1, 'event_id' => 8],
            ["course_id" => 1, 'event_id' => 9],
            ["course_id" => 1, 'event_id' => 10], 
        ]);
    }
}
