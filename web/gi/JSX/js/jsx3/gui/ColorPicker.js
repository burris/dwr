/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block","jsx3.gui.Form");jsx3.Class.defineClass("jsx3.gui.ColorPicker",jsx3.gui.Block,[jsx3.gui.Form],function(j,q){var
v=jsx3.gui.Interactive;var
jc=jsx3.gui.Block;var
Mb=jsx3.gui.Event;var
ib=jsx3.html.selectSingleElm;j.DEFAULT_WIDTH=324;j.DEFAULT_HEIGHT=300;j.HUE=1;j.SATURATION=2;j.BRIGHTNESS=3;j.jV=16;j.cu=8;j.UF=9;j.K7=9;var
hc="jsx:///images/colorpicker/";j.bt={_drag:jsx3.resolveURI(hc+"d1arrow.gif"),_1_v:jsx3.resolveURI(hc+"hue-v.png"),_1_h:jsx3.resolveURI(hc+"hue-h.png"),_2_v:jsx3.resolveURI(hc+"saturation-v.png"),_2_h:jsx3.resolveURI(hc+"saturation-h.png"),_3_v:jsx3.resolveURI(hc+"brightness-v.png")};for(var P in j.bt)jsx3.html.loadImages(j.bt[P]);q.init=function(k,n,i,f,c){this.jsxsuper(k,n,i,f,c);this.jsxrgb=16711680;this.jsxaxis=1;};q.getValue=function(){return this.jsxrgb;};q.setValue=function(i){var
ub=parseInt(i);if(!isNaN(ub)){this.setRGB(ub);}else if(typeof i=="string"){if(i.indexOf("#")==0)i=i.substring(1);ub=parseInt("0x"+i);if(!isNaN(ub))this.setRGB(ub);else this.setRGB(0);}else this.setRGB(0);};q.doValidate=function(){var
nc=1;this.setValidationState(nc);return nc;};q.getRGB=function(){return this.jsxrgb;};q.getRgbAsHex=function(){return "0x"+(16777216+(this.jsxrgb||Number(0))).toString(16).substring(1).toUpperCase();};q.setRGB=function(c){this.jsxrgb=Math.max(0,Math.min(c,16777215));this.dN(true,true);};q.getAxis=function(){return this.jsxaxis||1;};q.setAxis=function(b){this.jsxaxis=b;this.fi();return this;};q.setHSB=function(l,a,r){var
rc=j.HSBtoRGB(l,a,r);this.jsxrgb=(rc[0]<<16)+(rc[1]<<8)+rc[2];this.dN(true,true,[l,a,r]);};q.paint=function(){this.applyDynamicProperties();var
Yb=j.RGBtoHSB(this.jsxrgb);var
zb=j.HSBtoRGB(Yb[0],1,1);var
db="#"+j.T8(zb[0],zb[1],zb[2]);var
ob=this.renderAttributes(null,false);var
y=this.getAxis();var
u=this.vi(true);u.setAttributes('id="'+this.getId()+'" class="jsx30colorpicker" '+'label="'+this.getName()+'" '+this.vo()+this.fo()+ob+' unselectable="on"');u.setStyles(this.vl()+this.Af()+this.Dh());var
W=u.tp(0);var
Ac=W.tp(0);Ac.setAttributes(this.cn("mousedown","HV",2)+' unselectable="on"');var
ab=W.tp(1);ab.setAttributes(this.cn("mousedown","bT",2)+' unselectable="on"');var
Fb="",Q="";var
B=ab.Si(),Lc=ab.Zh();var
nb=Ac.Si(),kb=Ac.Zh();var
vb='<span unselectable="on" class="gradient" style="width:';if(y==1){Fb=Fb+(vb+nb+"px;height:"+kb+"px;background-color:"+db+';"></span>');Q=Q+this.k7(j.bt["_1_v"],B,Lc);}else{Fb=Fb+this.k7(j.bt["_1_h"],nb,kb);Q=Q+(vb+B+"px;height:"+Lc+"px;background-color:"+db+';"></span>');}if(y==2){Fb=Fb+(vb+nb+"px;height:"+kb+"px;background-color:#FFFFFF;"+jsx3.html.getCSSOpacity(1-Yb[1])+'"></span>');Q=Q+this.k7(j.bt["_2_v"],B,Lc);}else{Fb=Fb+this.k7(j.bt[y==1?"_2_h":"_2_v"],nb,kb);Q=Q+(vb+B+"px;height:"+Lc+"px;background-color:#FFFFFF;"+jsx3.html.getCSSOpacity(1-Yb[1])+'"></span>');}if(y==3){Fb=Fb+(vb+nb+"px;height:"+kb+"px;background-color:#000000;"+jsx3.html.getCSSOpacity(1-Yb[2])+'"></span>');Q=Q+this.k7(j.bt["_3_v"],B,Lc);}else{Fb=Fb+this.k7(j.bt["_3_v"],nb,kb);Q=Q+(vb+B+"px;height:"+Lc+"px;background-color:#000000;"+jsx3.html.getCSSOpacity(1-Yb[2])+'"></span>');}Fb=Fb+(vb+nb+"px;height:"+kb+'px;">&#160;</span>');Q=Q+(vb+B+"px;height:"+Lc+'px;">&#160;</span>');var
Nb=Ac.tp(0);Fb=Fb+Nb.paint().join(Nb.tp(0).paint().join(""));var
rb=W.tp(2);return u.paint().join(W.paint().join(Ac.paint().join(Fb)+ab.paint().join(Q)+rb.paint().join('<img src="'+j.bt["_drag"]+'" width="6" height="9"/>')+"&#160;"));};q.zj=function(d){var
db=jsx3.gui.Painted.Box;if(this.getParent()&&(d==null||isNaN(d.parentwidth)||isNaN(d.parentheight))){d=this.getParent().Ln(this);}else if(d==null)d={};var
uc=this.getRelativePosition()!=0;var
Nc=uc?null:this.getLeft();var
Ob=uc?null:this.getTop();var
gb=j.RGBtoHSB(this.jsxrgb);var
Sb=this.Ks(gb);d.boxtype=uc?"relativebox":"box";d.tagname="span";if(d.left==null&&Nc!=null)d.left=Nc;if(d.top==null&&Ob!=null)d.top=Ob;d.width=this.getWidth()||j.DEFAULT_WIDTH;d.height=this.getHeight()||j.DEFAULT_HEIGHT;var
Lc=new
db(d);var
F=Lc.Si();var
R=Lc.Zh();var
Gb=new
db({tagname:"div",boxtype:"inline",height:R,width:F});Lc.Od(Gb);var
Pb={tagname:"span",boxtype:"box",left:0,top:0,width:F-j.jV-j.cu,height:"100%",border:this.getBorder(),parentwidth:F,parentheight:R};var
Kb=new
db(Pb);Kb.setStyles("cursor:pointer;overflow:hidden;");Gb.Od(Kb);Pb={tagname:"span",boxtype:"box",left:F-j.jV,top:0,width:j.jV,height:"100%",border:this.getBorder(),parentwidth:F,parentheight:R};var
Dc=new
db(Pb);Dc.setStyles("cursor:pointer;");Gb.Od(Dc);var
ob=Math.round(Sb[1]*(Kb.Si()-1))-Math.floor(j.K7/2);var
vb=Math.round(Sb[2]*(Kb.Zh()-1))-Math.floor(j.K7/2);Pb={tagname:"span",boxtype:"box",left:ob,top:vb,width:j.K7,height:j.K7,border:"1px solid #CCCCCC;"};var
fb=new
db(Pb);fb.setStyles("overflow:hidden;");var
G=new
db({tagname:"span",boxtype:"box",left:0,top:0,width:j.K7-2,height:j.K7-2,border:"1px solid #333333;"});G.setStyles("overflow:hidden;");fb.Od(G);Kb.Od(fb);vb=Math.round(Sb[0]*(Dc.Zh()-1))-Math.floor(j.UF/2)+Dc.Jo();Pb={tagname:"span",boxtype:"box",left:F-j.jV-5,top:vb,width:6,height:j.UF};var
t=new
db(Pb);Gb.Od(t);return Lc;};q.Vd=function(g,d,k){this.Qh(g,d,k,1);};q.hP=function(o){switch(this.getAxis()){case 1:return [1-o[0],o[1],1-o[2]];case 2:return [1-o[1],1-o[0],1-o[2]];case 3:return [1-o[1],1-o[2],1-o[0]];default:throw new
jsx3.Exception();}};q.Ks=function(o){switch(this.getAxis()){case 1:return [1-o[0],o[1],1-o[2]];case 2:return [1-o[1],1-o[0],1-o[2]];case 3:return [1-o[2],1-o[0],1-o[1]];default:throw new
jsx3.Exception();}};q.k7=function(m,s,o){if(jsx3.CLASS_LOADER.IE6){return '<span unselectable="on" class="gradient" style="width:'+s+"px;height:"+o+"px;"+"filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+m+"', sizingMethod='scale');\"></span>";}else return '<img src="'+m+'" unselectable="on" class="gradient" style="width:'+s+"px;height:"+o+'px;"/>';};q.bT=function(l,a){Mb.unsubscribe("mousemove",this);Mb.subscribe("mousemove",this,"B3");Mb.subscribe("mouseup",this,"ZY");var
_=jsx3.html.getRelativePosition(a,l.srcElement());this._jsxoffsety=l.getTrueY()-l.getOffsetY()-Math.max(0,_.T);this.Rs(l,(l.getOffsetY()+_.T)/(a.offsetHeight-1),null,null);};q.HV=function(b,k){Mb.unsubscribe("mousemove",this);Mb.subscribe("mousemove",this,"yT");Mb.subscribe("mouseup",this,"ZY");var
D=jsx3.html.getRelativePosition(k,b.srcElement());this._jsxoffsetx=b.getTrueX()-b.getOffsetX()-Math.max(0,D.L);this._jsxoffsety=b.getTrueY()-b.getOffsetY()-Math.max(0,D.T);this.Rs(b,null,(b.getOffsetX()+D.L)/(k.offsetWidth-1),(b.getOffsetY()+D.T)/(k.offsetHeight-1));};q.B3=function(l){l=l.event;var
V=l.getTrueY()-this._jsxoffsety;var
Kb=ib(this.getRendered(l),0,1);V=Math.max(0,Math.min(Kb.offsetHeight-1,V));this.Rs(l,V/(Kb.offsetHeight-1),null,null);};q.yT=function(n){n=n.event;var
zc=n.getTrueX()-this._jsxoffsetx;var
_=n.getTrueY()-this._jsxoffsety;var
w=ib(this.getRendered(n),0,0);zc=Math.max(0,Math.min(w.offsetWidth-1,zc));_=Math.max(0,Math.min(w.offsetHeight-1,_));this.Rs(n,null,zc/(w.offsetWidth-1),_/(w.offsetHeight-1));};q.ZY=function(c){Mb.unsubscribe("mousemove",this);Mb.unsubscribe("mouseup",this);delete this._jsxoffsetx;delete this._jsxoffsety;};q.Rs=function(c,i,h,g){var
C=this.Ks(j.RGBtoHSB(this.jsxrgb));if(i!=null)C[0]=i;if(h!=null)C[1]=h;if(g!=null)C[2]=g;var
yc=this.hP(C);var
_=j.HSBtoRGB(yc[0],yc[1],yc[2]);this.jsxrgb=(_[0]<<16)+(_[1]<<8)+_[2];this.dN(i!=null,h!=null||g!=null,yc);this.doEvent("jsxchange",{objEVENT:c,intRGB:this.jsxrgb});};q.dN=function(k,r,p){var
Fc=this.getRendered();if(Fc!=null){if(p==null)p=j.RGBtoHSB(this.jsxrgb);var
F=j.HSBtoRGB(p[0],1,1);var
wc=this.getAxis();var
Ib=this.Ks(p);if(k){switch(wc){case 1:ib(Fc,0,0,0).style.backgroundColor="#"+j.T8(F[0],F[1],F[2]);break;case 2:jsx3.html.updateCSSOpacity(ib(Fc,0,0,1),1-p[1]);break;case 3:jsx3.html.updateCSSOpacity(ib(Fc,0,0,2),1-p[2]);break;default:throw new
jsx3.Exception();}var
Yb=ib(Fc,0,2);var
rb=this.vi(true).tp(0).tp(1);Yb.style.top=Math.round(Ib[0]*(rb.Zh()-1))-Math.floor(j.UF/2)+rb.Jo()+"px";}if(r){switch(wc){case 1:jsx3.html.updateCSSOpacity(ib(Fc,0,1,1),1-p[1]);jsx3.html.updateCSSOpacity(ib(Fc,0,1,2),1-p[2]);break;case 2:ib(Fc,0,1,0).style.backgroundColor="#"+j.T8(F[0],F[1],F[2]);jsx3.html.updateCSSOpacity(ib(Fc,0,1,2),1-p[2]);break;case 3:ib(Fc,0,1,0).style.backgroundColor="#"+j.T8(F[0],F[1],F[2]);jsx3.html.updateCSSOpacity(ib(Fc,0,1,1),1-p[1]);break;default:throw new
jsx3.Exception();}var
ac=ib(Fc,0,0,4);var
rb=this.vi(true).tp(0).tp(0);ac.style.left=Math.round(Ib[1]*(rb.Si()-1))-Math.floor(j.K7/2)+"px";ac.style.top=Math.round(Ib[2]*(rb.Zh()-1))-Math.floor(j.K7/2)+"px";}}};j.HSBtoRGB=function(e,r,f){var
gc=0,ub=0,Rb=0,z;e=360*(e-Math.floor(e));var
ob=255*f;var
Ib=ob*r;var
kc=ob-Ib;if(e>=300||e<60){if(e>=300)e=e-360;gc=ob;z=e*Ib/60;if(z<0){ub=kc;Rb=ub-z;}else{Rb=kc;ub=Rb+z;}}else if(e>=60&&e<180){ub=ob;z=(e-120)*Ib/60;if(z<0){Rb=kc;gc=Rb-z;}else{gc=kc;Rb=gc+z;}}else if(e>=180&&e<300){Rb=ob;z=(e-240)*Ib/60;if(z<0){gc=kc;ub=gc-z;}else{ub=kc;gc=ub+z;}}return [Math.round(gc),Math.round(ub),Math.round(Rb)];};j.RGBtoHSB=function(d,o,a){if(arguments.length==1){a=d&255;o=(d&65280)>>8;d=(d&16711680)>>16;}var
L=0,mc=1,Ic=1;var
uc=d>o?d:o;if(a>uc)uc=a;var
Nb=d<o?d:o;if(a<Nb)Nb=a;Ic=uc/255;if(uc!=0)mc=(uc-Nb)/uc;else mc=0;if(mc==0){L=0;}else{var
Jc=(uc-d)/(uc-Nb);var
Hc=(uc-o)/(uc-Nb);var
nb=(uc-a)/(uc-Nb);if(d==uc)L=nb-Hc;else if(o==uc)L=2+Jc-nb;else L=4+Hc-Jc;L=L/6;if(L<0)L=L+1;}return [L,mc,Ic];};j.T8=function(b,m,r){return (16777216+(b<<16)+(m<<8)+r).toString(16).substring(1);};});
