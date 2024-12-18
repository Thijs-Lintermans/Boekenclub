import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoekenComponent } from './components/boeken/boeken.component';
import { BesprekingenComponent } from './components/besprekingen/besprekingen.component';
import { RecensiesComponent } from './components/recensies/recensies.component';

export const routes: Routes = [
    { path: 'boeken', component: BoekenComponent },
    { path: 'besprekingen', component: BesprekingenComponent },
    { path: 'recensies', component: RecensiesComponent },
    { path: '', redirectTo: '/boeken', pathMatch: 'full' } // Default route
  ];  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
