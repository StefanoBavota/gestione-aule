<?php

namespace Database\Seeders;

use App\Models\Supervisor;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class SupervisorSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $supervisors = [
            ["Lorenzo", "lorenzo.bosica1@student.univaq.it"],
            ["Stefano", "stefano.bavota@student.univaq.it"],
            ["Denis", "denis.ciammaricone@student.univaq.it"],
        ];

        foreach ($supervisors as $supervisor) {
            Supervisor::create(['name' => $supervisor[0], 'email' => $supervisor[1]]);
        }


    }
}
