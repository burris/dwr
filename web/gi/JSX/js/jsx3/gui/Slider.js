/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Slider",jsx3.gui.Block,[jsx3.gui.Form],function(l,r){var
zc=jsx3.gui.Event;l.HORIZONTAL=0;l.VERTICAL=1;l.G6=100;l.gU=15;l.Op=7;l.KQ=l.gU;l.KF=15;l.L6=100;l.tU="jsx:///images/slider/top.gif";l.d8="jsx:///images/slider/bottom.gif";l.HW="jsx:///images/slider/left.gif";l.CA="jsx:///images/slider/right.gif";l.oQ="filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#aaffffff, EndColorStr=#FF9090af);";l._7="filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr=#aaffffff, EndColorStr=#FF9090af);";l.NS="border:solid 1px #9898a5;border-right-color:#ffffff;border-bottom-color:#ffffff;";l.Qp="border:solid 1px #9898a5;border-right-color:#ffffff;border-top-color:#ffffff;";r.jsxlength=100;r.jsxvalue=0;r.jsxpainttrack=1;r.jsxtrackclick=1;r.jsximg=null;r.init=function(b,d,i,j){this.jsxsuper(b,d,i);this.jsxlength=j;};r.getValue=function(){return this.jsxvalue!=null?this.jsxvalue:0;};r.setValue=function(h){this.jsxvalue=h==null?null:Math.max(0,Math.min(l.L6,Number(h)));this.v6();this.fi();return this;};r.doValidate=function(){return this.setValidationState(1).getValidationState();};r.getLength=function(){return this.jsxlength!=null?this.jsxlength:l.G6;};r.setLength=function(k,o){this.jsxlength=k;this.fi();if(o)this.repaint();return this;};r.setWidth=function(f,j){if(this.getOrientation()==0)this.setLength(f,j);return this;};r.setHeight=function(h,e){if(this.getOrientation()==1)this.setLength(h,e);return this;};r.getOrientation=function(){return this.jsxorientation!=null?this.jsxorientation:0;};r.setOrientation=function(c){this.jsxorientation=c;this.fi();return this;};r.getPaintTrack=function(){return this.jsxpainttrack!=null?this.jsxpainttrack:1;};r.setPaintTrack=function(f){this.jsxpainttrack=f;return this;};r.getTrackClickable=function(){return this.jsxtrackclick!=null?this.jsxtrackclick:1;};r.setTrackClickable=function(b){this.jsxtrackclick=b;return this;};r.getHandleImage=function(){return this.jsximg;};r.setHandleImage=function(k){this.jsximg=k;return this;};r.v6=function(){var
P=this.getRendered();if(P!=null){var
t=jsx3.html.selectSingleElm(P,0,0);var
lc=jsx3.html.selectSingleElm(P,0,1);if(this.getOrientation()==0){var
ec=parseInt(t.offsetWidth)-parseInt(lc.offsetWidth);lc.style.left=Math.round(this.getValue()*ec/l.L6)+"px";lc.style.top=Math.round((l.gU-l.KQ)/2)+"px";}else{var
u=parseInt(t.offsetHeight)-parseInt(lc.offsetHeight);lc.style.left=Math.round((l.gU-l.KQ)/2)+"px";lc.style.top=u-Math.round(this.getValue()*u/l.L6)+"px";}}};r.Vd=function(f,c,h){var
Mb=this.vi(true,f);if(c){var
Z=f.width!=null&&Mb.implicit.width!=f.width||f.parentwidth!=Mb.implicit.parentwidth&&typeof Mb.implicit.width=="string"&&Mb.implicit.width.indexOf("%")>0||f.height!=null&&Mb.implicit.height!=f.height||f.parentheight!=Mb.implicit.parentheight&&typeof Mb.implicit.height=="string"&&Mb.implicit.height.indexOf("%")>0;var
B=Mb.recalculate(f,c,h);if(!B.w&&!B.h)return;var
Mc=Mb.tp(0);Mc.recalculate({width:Mb.Si(),height:Mb.Zh()},c?c.childNodes[0]:null,h);var
vb=Mc.tp(0);vb.recalculate({width:Mc.Si(),height:Mc.Zh()},c?c.childNodes[0].childNodes[0]:null,h);if(Z)this.v6();}};r.zj=function(g){if(this.getParent()&&(g==null||isNaN(g.parentwidth)||isNaN(g.parentheight))){g=this.getParent().Ln(this);}else if(g==null)g={};var
I=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);var
Q=I?null:this.getLeft();var
Fc=I?null:this.getTop();var
W=this.getOrientation()==0;g.boxtype=I?"relativebox":"box";g.tagname="span";if(g.left==null&&Q!=null)g.left=Q;if(g.top==null&&Fc!=null)g.top=Fc;if(W){g.height=l.gU;g.width=this.getLength();}else{g.height=this.getLength();g.width=l.gU;}var
V=this.getMargin();if(I&&V!=null&&V!="")g.margin=V;var
cc=new
jsx3.gui.Painted.Box(g);var
Cb={};Cb.tagname="div";Cb.boxtype="inline";Cb.width=cc.Si();Cb.height=cc.Zh();var
P=Math.round((l.gU-l.Op)/2)+" ";var
C="0 ";Cb.padding=W?P+C+P+C:C+P+C+P;var
Kb=new
jsx3.gui.Painted.Box(Cb);cc.Od(Kb);Cb={};Cb.tagname="div";Cb.boxtype="inline";if(W){Cb.height=l.Op;Cb.width=Kb.Si();}else{Cb.height=Kb.Zh();Cb.width=l.Op;}Cb.border=this.getBorder()?this.getBorder():this.getOrientation()==0?l.NS:l.Qp;var
Vb=new
jsx3.gui.Painted.Box(Cb);Kb.Od(Vb);var
oc=W?Math.round(this.getValue()/l.L6*(Kb.Si()-l.KF)):Math.floor((l.gU-l.KQ)/2);var
jb=W?Math.floor((l.gU-l.KQ)/2):Math.round(Kb.Zh()-l.KF-this.getValue()/l.L6*(Kb.Zh()-l.KF));var
Dc=W?l.KF:l.KQ;var
ob=W?l.KQ:l.KF;Cb={};Cb.tagname="div";Cb.boxtype="box";Cb.left=oc;Cb.top=jb;Cb.width=Dc;Cb.height=ob;var
Yb=new
jsx3.gui.Painted.Box(Cb);cc.Od(Yb);Cb={};Cb.tagname="div";Cb.boxtype="inline";Cb.width=Dc;Cb.height=ob;var
wb=new
jsx3.gui.Painted.Box(Cb);Yb.Od(wb);return cc;};r.Rn=function(b,k){if(!b.hasModifier())if(b.isArrowKey()){if(b.upArrow()||b.rightArrow())this.G7(b,1);else if(b.downArrow()||b.leftArrow())this.G7(b,-1);b.cancelAll();}};r.ti=function(e,h){var
rc=e.getWheelDelta();if(rc!=0)this.G7(e,rc>0?1:-1);e.cancelBubble();};r.G7=function(f,h){var
Ac;if(h>0){if(this.jsxvalue>=l.L6)return;Ac=Math.floor(this.jsxvalue+h);while(Ac<l.L6){if(this.jsxvalue<this.constrainValue(Ac))break;Ac=Ac+h;}}else{if(this.jsxvalue<=0)return;Ac=Math.ceil(this.jsxvalue+h);while(Ac>0){if(this.jsxvalue>this.constrainValue(Ac))break;Ac=Ac+h;}}Ac=this.constrainValue(Ac);if(Ac!=this.jsxvalue){var
rb=this.doEvent("jsxchange",{objEVENT:f,fpPREVIOUS:this.jsxvalue,fpVALUE:Ac});if(rb!==false)this.setValue(Ac);}};l.Tk={};l.Tk["keydown"]=true;l.Tk["mousewheel"]=true;r.paint=function(){this.applyDynamicProperties();var
nb=this.getOrientation()==0;var
t=this.getEnabled()==1;var
Hc=this.qk(t?l.Tk:null,0);var
sc=this.renderAttributes(null,true);var
D=this.vi(true);D.setAttributes('id="'+this.getId()+'" class="jsx30slider" '+'label="'+this.getName()+'" '+this.vo()+this.fo()+Hc+sc);D.setStyles(this.Oo()+this.vl()+this.Af()+this.Dh());var
v=D.tp(0);var
Ec=!this.getPaintTrack()?"visibility:hidden;":"";var
F=this.getTrackClickable()&&t?this.cn("click","Uu",2):"";var
E=v.tp(0);E.setStyles(this.Dg()+this.mg()+Ec);E.setAttributes(' class="jsx30slider_track" '+F);var
bb=this.getHandleImage();if(bb==null)bb=nb?l.tU:l.HW;var
_b=D.tp(1);_b.setAttributes('class="handle"'+(t?this.cn("mousedown","hG",2):""));var
Cc=_b.tp(0);Cc.setAttributes(' class="handle'+(t?"":"_disabled")+'" unselectable="on"');Cc.setStyles("background-image:url("+this.getUriResolver().resolveURI(bb)+");");return D.paint().join(v.paint().join(E.paint().join("&#160;")+_b.paint().join(Cc.paint().join(""))));};r.hG=function(k,o){if(!k.leftButton())return;k.cancelBubble();k.cancelReturn();var
Xb=this.getOrientation()==0;var
lc=this;jsx3.gui.Interactive.ll(k,o,function(e,d,q){return lc.s9(q,e,d);});zc.subscribe("mousemove",this,"JZ");zc.subscribe("mouseup",this,"mv");};r.Uu=function(a,d){if(!a.leftButton())return;var
tc=this.getOrientation()==0;var
Pb=this.tT(tc?a.getOffsetX():a.getOffsetY());Pb=this.constrainValue(Pb);if(this.jsxvalue!=Pb){var
O=this.doEvent("jsxchange",{objEVENT:a,fpPREVIOUS:this.jsxvalue,fpVALUE:Pb});if(O!==false)this.setValue(Pb);}};r.s9=function(i,q,p){var
E=this.getRendered(i);var
lc=this.getOrientation()==0;var
R=0,Xb=0;if(E!=null){var
yc=jsx3.html.selectSingleElm(E,0,0);var
_b=jsx3.html.selectSingleElm(E,0,1);if(lc){Xb=_b.offsetY;var
z=l.L6*q/(yc.offsetWidth-_b.offsetWidth);z=this.constrainValue(z);R=Math.round(z*(yc.offsetWidth-_b.offsetWidth)/l.L6);}else{R=_b.offsetX;var
Dc=l.L6*p/(yc.offsetHeight-_b.offsetHeight);Dc=this.constrainValue(Dc);Xb=Math.round(Dc*(yc.offsetHeight-_b.offsetHeight)/l.L6);}}return [R,Xb];};r.JZ=function(e){var
cc=this.constrainValue(this.tT());this.doEvent("jsxincchange",{objEVENT:e.event,fpVALUE:cc});};r.mv=function(e){jsx3.EventHelp.reset();zc.unsubscribe("mousemove",this,"JZ");zc.unsubscribe("mouseup",this,"mv");var
zb=this.constrainValue(this.tT());var
ec=this.doEvent("jsxchange",{objEVENT:e.event,fpPREVIOUS:this.jsxvalue,fpVALUE:zb});if(ec===false){this.setValue(this.jsxvalue);}else{this.jsxvalue=zb;this.fi();}};r.tT=function(m){var
kb=this.getRendered();if(kb!=null){var
Qb=this.getOrientation()==0;var
nc=jsx3.html.selectSingleElm(kb,0,0);var
rb=jsx3.html.selectSingleElm(kb,0,1);return Qb?l.L6*(m!=null?m:rb.offsetLeft)/(nc.offsetWidth-rb.offsetWidth):l.L6*(1-(m!=null?m:rb.offsetTop)/(nc.offsetHeight-rb.offsetHeight));}else return 0;};r.constrainValue=function(s){return Math.max(0,Math.min(l.L6,s));};r.mg=function(){var
G=this.getBackground()||"";return G||this.Dg()?G+";":this.getOrientation()==0?l.oQ:l._7;};l.getVersion=function(){return "3.0.00";};});jsx3.Slider=jsx3.gui.Slider;
