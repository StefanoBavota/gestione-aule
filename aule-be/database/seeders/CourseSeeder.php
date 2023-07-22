<?php

namespace Database\Seeders;

use App\Models\Course;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class CourseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $courses = [

            "Advanced database system (basi di dati II)",
            "Advanced probability",
            "Web engineering",
            "Sviluppo web avanzato",
            "Analisi 1",
            "Ricerca Operativa",
            "Fisica",
            "Basi di dati laboratorio",
            "Fondamenti di programmazione",
            "CPU",
            "Seminario CyberSecurity",
            "Seminario Ingegneria del software",
            "Seminario sensibilizzazione igiene personale",
            "Matematica Discreta 1 e 2",
            "Teoria della calcolabilità e della complessità",
            "Web engineering",
            "Inglese B2",
            "Ottimizzazione combinatoria",
            "Laboratorio di algoritmica avanzata"
        ];

        foreach ($courses as $course) {
            Course::create(['name' => $course]);
        }
    }
}
