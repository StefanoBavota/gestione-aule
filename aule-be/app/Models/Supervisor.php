<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Supervisor extends Model
{
    use HasFactory;

    public $timestamps = false;

    protected $fillable = ['name', 'email'];

    public function rooms(): HasMany
    {
        return $this->hasMany(Room::class);
    }

    public function events(): HasMany
    {
        return $this->hasMany(Event::class);
    }

}
