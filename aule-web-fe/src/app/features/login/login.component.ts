import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ApiService } from '../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  form: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(8),
    ]),
  });

  constructor(private apiService: ApiService, private router: Router) {}

  ngOnInit(): void {}

  submit() {
    if (this.form.valid) {
      this.apiService.login(this.form.value).subscribe((res) => {
        localStorage.setItem('jwt', res.token);
        this.router.navigate(['/home']);
      });
    }
  }
}
