<?php

namespace Database\Seeders;

use App\Models\Room;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class RoomSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {

        $rooms =
            [
                ["name" => "C1.16", "capacity" => 46, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 6, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "0.6", "capacity" => 12, "supervisor_id" => 3, "description" => "i ragazzi tendono a perdersi", "ethernetPorts" => 3, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 3, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "1.1", "capacity" => 24, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 3, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 4, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "1.7 (Aula biancofiore]", "capacity" => 100, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 5, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 4, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "2.5", "capacity" => 100, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 3, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 5, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "Aula Rossa", "capacity" => 100, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 4, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "C1.9", "capacity" => 80, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 6, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "C1.10", "capacity" => 126, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 6, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A0.4", "capacity" => 46, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 3, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 1, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.1", "capacity" => 46, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.2", "capacity" => 46, "supervisor_id" => 3, "description" => "tenda della finestra rotta", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.3", "capacity" => 46, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.4", "capacity" => 46, "supervisor_id" => 3, "description" => "tenda della finestra rotta", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.5", "capacity" => 46, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.6", "capacity" => 100, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "A1.7", "capacity" => 100, "supervisor_id" => 3, "description" => "infestazione di formiche all'ingresso", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 2, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "Digital Class", "capacity" => 20, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 1, "location_id" => 1, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "B1.1", "capacity" => 40, "supervisor_id" => 2, "description" => "", "ethernetPorts" => 1, "electricalOutlets" => 4, "group_id" => 3, "location_id" => 16, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "B1.2", "capacity" => 25, "supervisor_id" => 1, "description" => "", "ethernetPorts" => 2, "electricalOutlets" => 5, "group_id" => 3, "location_id" => 17, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "F1.1", "capacity" => 100, "supervisor_id" => 1, "description" => "", "ethernetPorts" => 2, "electricalOutlets" => 4, "group_id" => 4, "location_id" => 18, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "F1.2", "capacity" => 25, "supervisor_id" => 1, "description" => "", "ethernetPorts" => 2, "electricalOutlets" => 5, "group_id" => 4, "location_id" => 19, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "D1.1", "capacity" => 75, "supervisor_id" => 2, "description" => "", "ethernetPorts" => 2, "electricalOutlets" => 5, "group_id" => 8, "location_id" => 20, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],
                ["name" => "D1.2", "capacity" => 50, "supervisor_id" => 3, "description" => "", "ethernetPorts" => 2, "electricalOutlets" => 5, "group_id" => 8, "location_id" => 21, 'link' => "https://material.angular.io/assets/img/examples/shiba1.jpg"],

            ];

        foreach ($rooms as $room) {
            Room::create($room);
        }

        DB::table('asset_room')->insert(
            ["room_id" => 11, "asset_id" => 1,],
            ["room_id" => 11, "asset_id" => 2,],
            ["room_id" => 11, "asset_id" => 5,],
            ["room_id" => 11, "asset_id" => 1,],
            ["room_id" => 11, "asset_id" => 1,],
            ["room_id" => 16, "asset_id" => 1,],
            ["room_id" => 16, "asset_id" => 2,],
            ["room_id" => 16, "asset_id" => 4,],
            ["room_id" => 16, "asset_id" => 5,],
            ["room_id" => 16, "asset_id" => 6,],
            ["room_id" => 16, "asset_id" => 7,],
            ["room_id" => 16, "asset_id" => 1,],
            ["room_id" => 16, "asset_id" => 1,],
            ["room_id" => 2,  "asset_id" => 3,],
            ["room_id" => 2,  "asset_id" => 8,],
            ["room_id" => 2,  "asset_id" => 11,],
        );
    }
}
