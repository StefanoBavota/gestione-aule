<?php

namespace Database\Seeders;

use App\Models\Group;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class GroupSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $groups = [

            ["DISIM", "Dipartimento di Ingegneria e Scienze dell'Informazione e Matematica", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["ATENEO", "Aule senza dipartimento", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["CLA", "Centro linguistico di ateneo", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["COSBE", "Polo laboratoriale didattico biologico-chimico", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DICEAA", "Dipartimento Ingegneria civile edile-architettura-ambiente", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DIIIE aule Roio", "Dipartimento di ingegneria industriale e dell'informazione e di economia", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DIIIE aule Acquasanta", "Dipartimento di ingegneria industriale e dell'informazione e di economia", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DISCAB", "Dipartimento scienze chimiche applicate e biotecnologiche", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DSFC", "Dipartimento di scienze fisiche e chimiche", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["DSU", "Dipartimento di scienze umane", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["MESVA", "Medicina clinica sanità pubblica scienze della vita e dell'ambiente", "https://aule.univaq.it/images_structures/diceaa.png"],
            ["MICROSCOPIA", "Centro di miscroscopia", "https://aule.univaq.it/images_structures/diceaa.png"],

        ];

        foreach ($groups as $group) {
            Group::create(['name' => $group[0], 'description' => $group[1], 'link' => $group[2]]);
        }
    }
}
