import { Component, OnDestroy, OnInit, Renderer2 } from '@angular/core';


@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  private styleLink!: HTMLLinkElement;
    private scriptElement!: HTMLScriptElement;
    private cssElement!: HTMLLinkElement;
  
    constructor(private renderer: Renderer2) {}

  ngOnInit() {
    this.cssElement = this.renderer.createElement('link');
    this.cssElement.rel = 'stylesheet';
    this.cssElement.href = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css';
    document.head.appendChild(this.cssElement);
    
    this.styleLink = this.renderer.createElement('link');
    this.styleLink.rel = 'stylesheet';
    this.styleLink.href = 'assets/css/dashboard.bootstrap.min.css'; // ✅ your custom version
    document.head.appendChild(this.styleLink);

    this.scriptElement = this.renderer.createElement('script');
    this.scriptElement.src = 'assets/js/dashboard.bootstrap.min.js';
    this.scriptElement.type = 'text/javascript';
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);
  }

  ngOnDestroy() {
    if (this.cssElement) {
      document.head.removeChild(this.cssElement); // ✅ remove when leaving dashboard
    }
    if (this.styleLink) {
      document.head.removeChild(this.styleLink); // ✅ remove when leaving dashboard
    }
    if (this.scriptElement) {
      document.body.removeChild(this.scriptElement);
    }
  }

}
