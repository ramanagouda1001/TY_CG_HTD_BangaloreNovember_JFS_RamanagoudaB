import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appColor]'
})
export class ColorDirective {

  
  constructor(public el: ElementRef,private renderer:Renderer2) {
    // this.el.nativeElement.style.background = 'red';
    // let h1 = this.renderer.createElement('h1');
    // let text = this.renderer.createText('HELLO FROM RAMANAGODA');
    // this.renderer.appendChild(h1,text);
    // this.renderer.appendChild(this.el.nativeElement,h1);
   }
   @HostListener('mouseenter')
   x() {
     this.el.nativeElement.style.background='#ee7e34';
   }

   @HostListener('mouseleave')
   y() {
     this.el.nativeElement.style.background="white";
   }
}
