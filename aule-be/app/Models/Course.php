<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsToMany;

class Course extends Model
{
    use HasFactory;

    public $timestamps = false;

    public function events(): BelongsToMany
    {
        return $this->belongsToMany(Event::class);
    }
}
