<?php

use App\Http\Controllers\AuthController;
use App\Http\Controllers\AssetController;
use App\Http\Controllers\EventController;
use App\Http\Controllers\GroupController;
use App\Http\Controllers\RoomController;
use App\Http\Controllers\TypologyController;
use App\Http\Controllers\SupervisorController;
use App\Http\Controllers\LocationController;
use App\Http\Controllers\CourseController;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/


Route::prefix('auth')->group(function(){

    Route::post('login', [AuthController::class, "login"])->name('login');

});

Route::middleware('auth:sanctum')->group(function () {

    Route::prefix('classrooms')->group(function () {
        Route::post('/', [RoomController::class, "store"]);
        Route::put('/{id}', [RoomController::class, "update"]);
        Route::delete('/{id}', [RoomController::class, "destroy"]);
    });

    Route::prefix('groups')->group(function () {
        Route::post('/', [GroupController::class, "store"]);
        Route::put('/{id}', [GroupController::class, "update"]);
        Route::delete('/{id}', [GroupController::class, "destroy"]);
    });

    Route::prefix('events')->group(function () {
        Route::post('/', [EventController::class, 'store']);
        Route::put('/{id}', [EventController::class, 'update']);
        Route::delete('/{id}', [EventController::class, "destroy"]);
    });

    Route::prefix('assets')->group(function () {
        Route::post('/', [AssetController::class, 'store']);
        Route::put('/{id}', [AssetController::class, 'update']);
        Route::delete('/{id}', [AssetController::class, "destroy"]);
    });
});

Route::prefix('classrooms')->group(function () {
    Route::get('/', [RoomController::class, "index"]);
    Route::get('/{id}', [RoomController::class, "show"])->where('id', '[0-9]+');
    Route::get('/get-room-events', [RoomController::class, "getRoomEventsByDateAndGroup"])->where('get-room-events', '[A-Za-z]+');
});


Route::prefix('groups')->group(function () {
    Route::get('/', [GroupController::class, "index"]);
    Route::get('/{id}', [GroupController::class, "show"]);
});

Route::prefix('events')->group(function () {
    Route::get('/', [EventController::class, "index"]);
    Route::get('/{id}', [EventController::class, "show"])->where('id', '[0-9]+');
    Route::get('/current', [EventController::class, "getWeeklyEventsByCourseId"]);
    Route::get('/export-csv', [EventController::class, "exportToCSV"])->where('export-csv', '[A-Za-z]+');
    Route::get('/next-events', [EventController::class, "getNextEventsByGroupId"])->where('next-events', '[A-Za-z]+');
});

Route::prefix('assets')->group(function () {
    Route::get('/', [AssetController::class, "index"]);
    Route::get('/{id}', [AssetController::class, "show"]);
});

Route::prefix('typologies')->group(function () {
    Route::get('/', [TypologyController::class, "index"]);
});

Route::prefix('supervisors')->group(function () {
    Route::get('/', [SupervisorController::class, "index"]);
});

Route::prefix('locations')->group(function () {
    Route::get('/', [LocationController::class, "index"]);
});

Route::prefix('courses')->group(function () {
    Route::get('/', [CourseController::class, "index"]);
});