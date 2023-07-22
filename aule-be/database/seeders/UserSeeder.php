<?php

namespace Database\Seeders;

use App\Models\User;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        User::factory()->create([
            'name' => 'Lorenzo',
            'email' => 'lorenzo@univaq.it'
        ]);

        User::factory()->create([
            'name' => 'Stefano',
            'email' => 'stefano@univaq.it'
        ]);

        User::factory()->create([
            'name' => 'Denis',
            'email' => 'denis@univaq.it'
        ]);
    }
}
