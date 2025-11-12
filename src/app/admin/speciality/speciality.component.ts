import { Component, OnInit, OnDestroy, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-speciality',
  templateUrl: './speciality.component.html',
  styleUrls: ['./speciality.component.css']
})
export class SpecialityComponent implements OnInit {

    private styleLink!: HTMLLinkElement;
    private scriptElement!: HTMLScriptElement;
    private cssElement!: HTMLLinkElement;
    private popperScript!: HTMLScriptElement;
  private bootstrapScript!: HTMLScriptElement;
  
    constructor(private renderer: Renderer2) {}

 ngOnInit() {
    this.cssElement = this.renderer.createElement('link');
    this.cssElement.rel = 'stylesheet';
    this.cssElement.href = 'https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css';
    document.head.appendChild(this.cssElement);
    
    this.styleLink = this.renderer.createElement('link');
    this.styleLink.rel = 'stylesheet';
    this.styleLink.href = 'assets/css/dashboard.bootstrap.min.css'; // custom version
    document.head.appendChild(this.styleLink);

    this.scriptElement = this.renderer.createElement('script');
    this.scriptElement.src = 'assets/js/dashboard.bootstrap.min.js';
    this.scriptElement.type = 'text/javascript';
    this.scriptElement.async = true;
    document.body.appendChild(this.scriptElement);

    // 3️⃣ Popper (required by Bootstrap)
    this.popperScript = this.renderer.createElement('script');
    this.popperScript.src = 'https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js';
    this.popperScript.type = 'text/javascript';
    this.popperScript.defer = true;
    document.body.appendChild(this.popperScript);

    // 4️⃣ Bootstrap JS (depends on Popper)
    this.bootstrapScript = this.renderer.createElement('script');
    this.bootstrapScript.src = 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js';
    this.bootstrapScript.type = 'text/javascript';
    this.bootstrapScript.defer = true;
    document.body.appendChild(this.bootstrapScript);
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
