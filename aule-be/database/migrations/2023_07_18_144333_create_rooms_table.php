<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('rooms', function (Blueprint $table) {
            $table->id();
            $table->string('name');
            $table->integer('capacity');
            $table->text('description');
            $table->integer('electricalOutlets');
            $table->integer('ethernetPorts');
            $table->string('link');
            $table->foreignId('supervisor_id')->references('id')->on('supervisors');
            $table->foreignId('group_id')->references('id')->on('groups');
            $table->foreignId('location_id')->references('id')->on('locations');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('rooms');
    }
};
