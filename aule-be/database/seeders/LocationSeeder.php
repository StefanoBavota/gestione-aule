<?php

namespace Database\Seeders;

use App\Models\Location;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class LocationSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $locations = [
            ["Coppito","Alan Touring (Coppito 0)", "terra"],
            ["Coppito","Alan Touring (Coppito 0)", "primo"],
            ["Coppito","Coppito 1", "terra"],
            ["Coppito","Coppito 1", "primo"],
            ["Coppito","Coppito 1", "secondo"],
            ["Coppito","Coppito 2", "terra"],
            ["Coppito","Coppito 2", "primo"],
            ["Coppito","Coppito 2", "secondo"],
            ["Coppito","11 A", "terra"],
            ["Coppito","11 A", "primo"],
            ["Coppito","11 A", "secondo"],
            ["Coppito","11 A", "terzo"],
            ["Coppito","11 B", "terra"],
            ["Coppito","11 B", "primo"],
            ["Coppito","11 B", "secondo"],
            ["Roio", "Blocco Pontieri", "terra"],
            ["Roio", "Blocco Pontieri", "primo"],
            ["Roio", "Blocco Pontieri", "secondo"],
            ["Roio", "Blocco Pontieri", "terzo"],
            ["L'Aquila Centro","Rettorato","terra"],
            ["L'Aquila Centro","Rettorato","primo"],
            ["L'Aquila Centro","Rettorato","sacondo"]
        ];

        foreach ($locations as $location) {
            Location::create(['place' => $location[0], 'building' => $location[1], 'floor' => $location[2]]);
        }
    }
}
