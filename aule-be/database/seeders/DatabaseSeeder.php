<?php

namespace Database\Seeders;

// use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        $this->call([
            UserSeeder::class,
            GroupSeeder::class,
            LocationSeeder::class,
            SupervisorSeeder::class,
            AssetSeeder::class,
            CourseSeeder::class,
            RoomSeeder::class,
            TypologySeeder::class,
            EventSeeder::class,
        ]);
    }
}
