import { Component, OnDestroy,AfterViewInit, OnInit, Renderer2 } from '@angular/core';
declare var Quill: any;

@Component({
  selector: 'app-medicine',
  templateUrl: './medicine.component.html',
  styleUrls: ['./medicine.component.css']
})
export class MedicineComponent implements OnInit {

    private styleLink!: HTMLLinkElement;
    private scriptElement!: HTMLScriptElement;
    private cssElement!: HTMLLinkElement;
    private popperScript!: HTMLScriptElement;
    private bootstrapScript!: HTMLScriptElement;
    private quillCss!: HTMLLinkElement;
    private quillJs!: HTMLScriptElement;
    editors: any[] = [];

    constructor(private renderer: Renderer2) {}

    initQuillEditor(editorId: string) {
      return new Quill(`#${editorId}`, {
        theme: 'snow',
        modules: {
          toolbar: [
            ['bold', 'italic', 'underline'],
            [{ list: 'ordered' }, { list: 'bullet' }],
            [{ header: [1, 2, 3, false] }],
            ['clean']
          ]
        }
    });
  }

  ngAfterViewInit() {
    this.quillJs.onload = () => {
      for (let i = 1; i <= 12; i++) {
        this.initQuillEditor(`editor${i}`);
      }
    };
  }

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

    // Popper (required by Bootstrap)
    this.popperScript = this.renderer.createElement('script');
    this.popperScript.src = 'https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js';
    this.popperScript.type = 'text/javascript';
    this.popperScript.defer = true;
    document.body.appendChild(this.popperScript);

    // Bootstrap JS (depends on Popper)
    this.bootstrapScript = this.renderer.createElement('script');
    this.bootstrapScript.src = 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js';
    this.bootstrapScript.type = 'text/javascript';
    this.bootstrapScript.defer = true;
    document.body.appendChild(this.bootstrapScript);

    // Quill JS
    this.quillJs = this.renderer.createElement('script');
    this.quillJs.src = 'https://cdn.quilljs.com/1.3.7/quill.js';
    this.quillJs.type = 'text/javascript';
    this.quillJs.defer = true;
    document.body.appendChild(this.quillJs);

    //quill css
    this.quillCss = this.renderer.createElement('link');
    this.quillCss.rel = 'stylesheet';
    this.quillCss.href = 'https://cdn.quilljs.com/1.3.7/quill.snow.css';
    document.head.appendChild(this.quillCss);
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
