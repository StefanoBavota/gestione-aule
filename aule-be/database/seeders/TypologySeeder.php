<?php

namespace Database\Seeders;

use App\Models\Typology;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class TypologySeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $typologies = [
          ["seminario"],
          ["riunione"],
          ["lauree"],
          ["lezione"],
          ["esame"],
          ["parziale"],
          ["altro"],
        ];

        foreach ($typologies as $typology) {
          Typology::create(['name' => $typology[0]]);
        }

    }
}
