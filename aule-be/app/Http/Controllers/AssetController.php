<?php

namespace App\Http\Controllers;

use App\Models\Asset;
use Illuminate\Http\Request;

class AssetController extends Controller
{
    public function index()
    {
        return Asset::all();
    }

    public function store(Request $request)
    {

        $validated = $request->validate([

            'name' => 'required|string'

        ]);

        return Asset::create($validated);

    }

    public function show(string $id)
    {
        return Asset::findOrFail($id);
    }

    public function destroy(string $id)
    {
        $asset = Asset::findOrFail($id);

        $asset->delete();
    }

    public function update(Request $request, string $id)
    {
        $asset = Asset::findOrFail($id);

        if($request->has("name")){
            $asset->name = $request->get("name");
        }

        return $asset->save(); //May return the entire event
    }

}
