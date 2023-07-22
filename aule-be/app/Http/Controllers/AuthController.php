<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Http\JsonResponse;

use App\Models\User;

class AuthController extends Controller
{

    public function login(Request $request): JsonResponse
    {

        $credentials = request(['email', 'password']);

        $error_response = [
            [
                'message' => 'the given data was invalid',
                'errors' => [
                    'password' => [
                        'Invalid Credentials'
                    ]
                ]
            ]
        ];

        if (!auth()->attempt($credentials)) {
            return response()->json($error_response, 422);
        }

        $user = User::where('email', $request->email)->first();
        $authToken = $user->createToken('auth-token')->plainTextToken;

        return response()->json([
            'access_token' => $authToken,
        ]);
    }

}
