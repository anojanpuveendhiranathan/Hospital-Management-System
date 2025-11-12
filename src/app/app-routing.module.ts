import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccesseverythingComponent } from './accesseverything/accesseverything.component';
import { AddpatientComponent } from './addpatient/addpatient.component';
import {DoctorlistsComponent} from './doctorlists/doctorlists.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PatientinformationComponent } from './patientinformation/patientinformation.component';
import { PatientlistsComponent } from './patientlists/patientlists.component';
import { PrescriptionComponent } from './prescription/prescription.component';
import { RoughComponent } from './rough/rough.component';
import { ShowdocinfoComponent } from './showdocinfo/showdocinfo.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { DoctorComponent } from './admin/doctor/doctor.component';
import { AddDoctorComponent } from './admin/add-doctor/add-doctor.component';
import { NurseComponent } from './admin/nurse/nurse.component';
import { AddNurseComponent } from './admin/add-nurse/add-nurse.component';
import { SpecialityComponent } from './admin/speciality/speciality.component';

const routes: Routes = [
  {path:"doctors_info", component: DoctorlistsComponent},
  {path:"patients_info", component: PatientlistsComponent},
  {path:"", component: HomepageComponent},
  {path:"addpatient", component: AddpatientComponent},
  {path:"checkpatientinfo", component: PatientinformationComponent},
  {path:"accesseverything", component: AccesseverythingComponent},
  {path:"showdocinfo",component: ShowdocinfoComponent},
  {path:"rough",component:RoughComponent},
  {path:"presc",component:PrescriptionComponent},
  {path:"admin/login",component:AdminLoginComponent},
  {path:"admin/dashboard",component:DashboardComponent},
  {path:"admin/dashboard/doctor",component:DoctorComponent},
  {path:"admin/dashboard/add-doctor",component:AddDoctorComponent},
  {path:"admin/dashboard/nurse",component:NurseComponent},
  {path:"admin/dashboard/add-nurse",component:AddNurseComponent},
  {path:"admin/dashboard/speciality",component:SpecialityComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
