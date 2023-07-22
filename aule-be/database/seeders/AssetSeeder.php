<?php

namespace Database\Seeders;

use App\Models\Asset;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class AssetSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $assets = [

            "proiettore",
            "schermo motorizzato",
            "schermo manuale",
            "imp.audio",
            "pc fisso",
            "mic.a filo",
            "mic. senza filo",
            "lavagna luminosa",
            "visual presenter",
            "imp. elettrico",
            "allestimento",
            "lavagna",

        ];

        foreach ($assets as $asset) {
            Asset::create(['name' => $asset]);
        }
    }
}
