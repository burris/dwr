/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Splitter",jsx3.gui.Block,null,function(m,f){var
W=jsx3.gui.Event;var
Q=jsx3.gui.Interactive;m.ORIENTATIONH=0;m.ORIENTATIONV=1;m.w8="jsx:///images/splitter/v.gif";m.bJ="jsx:///images/splitter/h.gif";jsx3.html.loadImages("jsx:///images/splitter/v.gif","jsx:///images/splitter/h.gif");m._6="#2050df";m.rw="#c8c8d5";m.t4="#ffffff";f.init=function(i,s){this.jsxsuper(i);if(s!=null)this.setOrientation(s);for(var
X=1;X<=2;X++){var
wb=new
jsx3.gui.Block(i+"_"+X,null,null,"100%","100%","");wb.setRelativePosition(1);wb.setBackgroundColor(m.t4);this.setChild(wb,1,null,"JSXFRAG");}};f.paintChild=function(e,q){if(!q)this.repaint();};f.Ln=function(a){var
qb=a.getChildIndex();var
N=this.Jm(qb);if(N)return N;var
D=this.getParent().Ln(this);var
Ic=D.width?D.width:D.parentwidth;var
Zb=D.height?D.height:D.parentheight;var
Qb=Number(this.getSubcontainer1Pct().replace(/%/g,""))/100;var
ec=this.getOrientation()==0;var
U=0,yb=0,Ib=Ic,J=Zb;if(qb==0){if(ec){Ib=parseInt(Ic*Qb);}else J=parseInt(Zb*Qb);}else if(ec){U=parseInt(Ic*Qb)+8;Ib=Ib-U;}else{yb=parseInt(Zb*Qb)+8;J=J-yb;}return this.li(qb,{boxtype:"box",tagname:"div",left:U,top:yb,width:Ib,height:J,parentwidth:Ib,parentheight:J});};f.Vd=function(n,j,e){var
P=this.vi(true,n);if(j){P.recalculate(n,j,e);var
Vb=this.getChildren();var
rb=Vb.length>2?2:Vb.length;var
Cc=0;for(var
A=0;A<rb;A++){var
Ob=this.Ln(Vb[A]);if(A==1){var
tb=P.tp(0);if(this.getOrientation()==0){tb.recalculate({left:Cc,parentheight:N},j?j.childNodes[0]:null,e);}else tb.recalculate({top:Cc,parentwidth:C},j?j.childNodes[0]:null,e);}e.add(Vb[A],Ob,j?j.childNodes[A+1]:null,true);var
C=Ob.width!=null?Ob.width:Ob.parentwidth;var
N=Ob.height!=null?Ob.height:Ob.parentheight;Cc=this.getOrientation()==0?C:N;}}};f.zj=function(c){this.applyDynamicProperties();if(this.getParent()&&(c==null||!isNaN(c.parentwidth)&&!isNaN(c.parentheight)||!isNaN(c.width)&&!isNaN(c.height))){c=this.getParent().Ln(this);}else if(c==null)c={};var
ob=this.getRelativePosition()!=0;if(c.left==null||!ob&&!jsx3.util.strEmpty(this.getLeft()))c.left=this.getLeft();if(c.top==null||!ob&&!jsx3.util.strEmpty(this.getTop()))c.top=this.getTop();if(c.width==null)c.width="100%";if(c.height==null)c.height="100%";c.tagname="div";c.boxtype="box";var
jb=new
jsx3.gui.Painted.Box(c);var
xc={};xc.tagname="div";xc.boxtype="box";var
z=Number(this.getSubcontainer1Pct().replace(/%/g,""))/100;xc.parentwidth=jb.Si();xc.parentheight=jb.Zh();var
kc=this.Ln(this.getChild(0));var
V=this.getOrientation()==0?kc.width:kc.height;if(this.getOrientation()==0){xc.left=V;xc.top=0;xc.width=8;xc.height="100%";}else{xc.left=0;xc.top=V;xc.width="100%";xc.height=8;}var
nc=new
jsx3.gui.Painted.Box(xc);jb.Od(nc);return jb;};f.paint=function(){this.applyDynamicProperties();var
bb=this.cn("mousedown","doBeginMove",1);var
Fb=this.renderAttributes(null,true);var
U=this.vi(true);U.setAttributes(this.vo()+this.fo()+' id="'+this.getId()+'" class="jsx30splitter"'+this.so()+Fb);U.setStyles(this.Dg()+this.Af()+this.Dh()+this.paintWrap()+this.ji());var
ec=U.tp(0);ec.setAttributes(bb+' class="jsx30splitter_'+(this.getOrientation()==0?"h":"v")+'bar"');ec.setStyles(this.Dg()+(this.getOrientation()==0?this.r0():this.JK()));var
fb,hb;if((fb=this.getChild(0))!=null)fb.ak(this.Ln(fb));if((hb=this.getChild(1))!=null)hb.ak(this.Ln(hb));return U.paint().join(ec.paint().join("&#160;")+this.paintChildren());};f.Dg=function(){return "background-color:"+(this.getBackgroundColor()?this.getBackgroundColor():m.rw)+";";};f.paintWrap=function(){return "";};f.doBeginMove=function(d,i){if(!d.leftButton())return;if(this.doEvent("jsxbeforeresize",{objEVENT:d,objGUI:i})===false)return;i.style.backgroundColor=m._6;this._jsxmoving=true;if(this.getOrientation()==0){jsx3.EventHelp.constrainY=true;}else jsx3.EventHelp.constrainX=true;this.jsxsupermix(d,i);W.subscribe("mouseup",this,"doResizeEnd");};f.doResizeEnd=function(o){o=o.event;var
gc=this.getRendered(o).childNodes[0];W.unsubscribe("mouseup",this,"doResizeEnd");if(!this._jsxmoving)return;this._jsxmoving=false;o.releaseCapture(gc);gc.style.backgroundColor=this.getBackgroundColor()?this.getBackgroundColor():m.rw;if(this.getOrientation()==0){var
L=parseInt(gc.style.left);var
N=gc.parentNode.offsetWidth;if(L<this.getSubcontainer1Min())L=this.getSubcontainer1Min();if(L>N-8)L=N-8;var
ob=L/N*100;ob=parseInt(ob*100)/100;var
V=ob+"%";}else{var
L=parseInt(gc.style.top);var
N=gc.parentNode.offsetHeight;if(L<this.getSubcontainer1Min())L=this.getSubcontainer1Min();if(L>N-8)L=N-8;var
ob=L/N*100;ob=parseInt(ob*100)/100;var
V=ob+"%";}this.setSubcontainer1Pct(V,true);this.doEvent("jsxafterresize",{objEVENT:o,objGUI:gc});};f.getSubcontainer1Pct=function(){return this.jsxsubcontainer1pct==null?"50%":this.jsxsubcontainer1pct;};f.setSubcontainer1Pct=function(k,r){if(typeof k=="number")k=k+"%";this.jsxsubcontainer1pct=k;if(r){var
rb=this.getRendered();if(rb!=null)this.Ch({parentwidth:rb.offsetWidth,parentheight:rb.offsetHeight},rb);}return this;};f.getSubcontainer2Pct=function(){return this.jsxsubcontainer2pct==null?"49.999%":this.jsxsubcontainer2pct;};f.setSubcontainer2Pct=function(d){this.jsxsubcontainer2pct=d;return this;};f.getSubcontainer1Min=function(){return this.jsxsubcontainer1min==null?1:this.jsxsubcontainer1min;};f.setSubcontainer1Min=function(g){this.jsxsubcontainer1min=g;return this;};f.getSubcontainer2Min=function(){return this.jsxsubcontainer2min==null?8:this.jsxsubcontainer2min;};f.setSubcontainer2Min=function(p){this.jsxsubcontainer2min=p;return this;};f.getOrientation=function(){return this.jsxorientation==null?0:this.jsxorientation;};f.setOrientation=function(d){this.jsxorientation=d;this.fi();return this;};f.getVSplitImage=function(){return this.jsxvsplitimage==null?m.w8:this.jsxvsplitimage;};f.setVSplitImage=function(o){this.jsxvsplitimage=o;return this;};f.getHSplitImage=function(){return this.jsxhsplitimage==null?m.bJ:this.jsxhsplitimage;};f.setHSplitImage=function(b){this.jsxhsplitimage=b;return this;};f.JK=function(){var
Vb=this.getVSplitImage();return Vb.search(/background-image\s*:\s*url\(/)!=-1?Vb:"background-image:url("+jsx3.resolveURI(Vb)+");background-repeat:no-repeat;background-position:center center;";};f.r0=function(){var
Ic=this.getHSplitImage();return Ic.search(/background-image\s*:\s*url\(/)!=-1?Ic:"background-image:url("+jsx3.resolveURI(Ic)+");background-repeat:no-repeat;background-position:center center;";};f.onSetChild=function(n){return this.getChildren().length<2;};m.getVersion=function(){return "3.0.00";};});jsx3.Splitter=jsx3.gui.Splitter;
