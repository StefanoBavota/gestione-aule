<?php

namespace App\Http\Controllers;

use App\Models\Typology;
use Illuminate\Http\Request;

class TypologyController extends Controller
{
    public function index()
    {
        return Typology::all();
    }
}
