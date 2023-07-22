<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

class Location extends Model
{
    use HasFactory;

    public $timestamps = false;

    protected $fillable = ['place', 'building', 'floor'];

    public function rooms(): HasMany
    {
        return $this->hasMany(Room::class);
    }
}
