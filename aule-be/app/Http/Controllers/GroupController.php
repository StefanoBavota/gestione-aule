<?php

namespace App\Http\Controllers;

use App\Models\Group;
use Illuminate\Http\Request;

class GroupController extends Controller
{

    public function index()
    {
        return Group::all();
    }

    public function store(Request $request)
    {

        $validated = $request->validate([

            'name' => 'required|string',
            'description' => 'required|string|nullable',
            'link' => 'required|string|nullable',

        ]);

        return Group::create($validated);

    }

    public function show(string $id)
    {
        return Group::findOrFail($id);
    }

    public function destroy(string $id)
    {
        $group = Group::findOrFail($id);

        $group->delete();
    }

    public function update(Request $request, string $id)
    {
        $group = Group::findOrFail($id);

        if($request->has("name")){
            $group->name = $request->get("name");
        }
        if($request->has("description")){
            $group->description = $request->get("description");
        }
        if($request->has("link")){
            $group->link = $request->get("link");
        }

        return $group->save(); //May return the entire event
    }


}
