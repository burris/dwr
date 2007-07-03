/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.ImageButton",jsx3.gui.Block,[jsx3.gui.Form],function(p,n){var
Vb=jsx3.gui.Event;var
Zb=jsx3.gui.Interactive;var
gb=jsx3.gui.Form;p.TYPE_NORMAL=0;p.TYPE_TOGGLE=1;p.STATE_OFF=0;p.STATE_ON=1;n.jsximage=null;n.jsxoverimage=null;n.jsxdownimage=null;n.jsxonimage=null;n.jsxdisabledimage=null;n.jsxprefetch=1;n.jsxtype=0;n.jsxstate=0;n._jsxT0=null;n.init=function(s,i,d,q,k){this.jsxsuper(s,i,d,q,k);};n.getImage=function(){return this.jsximage;};n.setImage=function(g){this.jsximage=g;return this;};n.getOverImage=function(){return this.jsxoverimage;};n.setOverImage=function(s){this.jsxoverimage=s;return this;};n.getDownImage=function(){return this.jsxdownimage;};n.setDownImage=function(q){this.jsxdownimage=q;return this;};n.getOnImage=function(){return this.jsxonimage;};n.setOnImage=function(m){this.jsxonimage=m;return this;};n.getDisabledImage=function(){return this.jsxdisabledimage;};n.setDisabledImage=function(c){this.jsxdisabledimage=c;return this;};n.getState=function(){return this.jsxstate;};n.setState=function(c){this.jsxstate=c;var
rc=this.getRendered();if(rc!=null)rc.src=this.r_(false,false);return this;};n.getType=function(){return this.jsxtype;};n.setType=function(k){this.jsxtype=k;return this;};n.isPreFetch=function(){return this.jsxprefetch;};n.setPreFetch=function(d){this.jsxprefetch=jsx3.Boolean.valueOf(d);return this;};n.setEnabled=function(c,e){if(this._jsxT0!=null)this._jsxT0.setEnabled(c==1);return this.jsxsupermix(c,e);};p.Tk={};p.Tk["click"]=true;p.Tk["mouseover"]=true;p.Tk["mouseout"]=true;p.Tk["mousedown"]=true;p.Tk["mouseup"]=true;p.Tk["keydown"]=true;n.paint=function(){this.applyDynamicProperties();var
Pb=this.getEnabled()==1;var
mc=this.getKeyBinding();if(mc){var
P=this;if(this._jsxT0!=null)this._jsxT0.destroy();this._jsxT0=this.doKeyBinding(function(i){P.Th(i,P.getRendered());},mc);this._jsxT0.setEnabled(Pb);}var
Kc=this.qk(Pb?p.Tk:null,0);var
cb=this.renderAttributes(null,true);var
kb=this.vi(true);kb.setAttributes('id="'+this.getId()+'"'+this.so()+this.vo()+this.fo()+' class="'+(Pb?"jsx30imagebutton":"jsx30imagebutton_disabled")+'"'+Kc+cb);kb.setStyles(this.Nh()+this.Af()+this.Dh()+this.vl()+this.Dg()+this.ji());var
Hc=kb.Si();Hc=Hc!=null?' width="'+Hc+'"':"";var
nb=kb.Zh();nb=nb!=null?' height="'+nb+'"':"";var
jc='<img src="'+this.r_(false,false)+'"'+Hc+nb+"/>";if(!this._jsxDC&&this.isPreFetch()){var
nc=this.getUriResolver();var
ec=[this.getImage(),this.getOverImage(),this.getDownImage(),this.getOnImage(),this.getDisabledImage()].map(function(a){return a?nc.resolveURI(a):null;});jsx3.html.loadImages(ec);this._jsxDC=true;}var
S=kb.tp(0);return kb.paint().join(S.paint().join(jc));};n.zj=function(){var
Qb=this.getRelativePosition()!=0;var
D={};if(!Qb&&!jsx3.util.strEmpty(this.getLeft()))D.left=this.getLeft();if(!Qb&&!jsx3.util.strEmpty(this.getTop()))D.top=this.getTop();if(!(this.getWidth()==null||isNaN(this.getWidth())))D.width=this.getWidth();if(!(this.getHeight()==null||isNaN(this.getHeight())))D.height=this.getHeight();D.tagname="span";D.boxtype=Qb||D.left==null||D.top==null?"relativebox":"box";if(this.getPadding()!=null)D.padding=this.getPadding();if(Qb&&this.getMargin()!=null)D.margin=this.getMargin();if(this.getBorder()!=null)D.border=this.getBorder();var
Fc=new
jsx3.gui.Painted.Box(D);D={tagname:"div",boxtype:"inline",height:Fc.Zh()};Fc.Od(new
jsx3.gui.Painted.Box(D));return Fc;};n.Vd=function(e,b,m){this.Qh(e,b,m,1);};n.r_=function(o,i){var
Ic=null;if(this.getEnabled()==1){if(o)Ic=this.getOverImage();else if(i)Ic=this.getDownImage();if(this.getType()==1&&this.getState()==1)Ic=Ic||this.getOnImage();}else Ic=this.getDisabledImage();Ic=Ic||this.getImage();return Ic?this.getUriResolver().resolveURI(Ic):"";};n.Th=function(e,h){if(!e.leftButton()&&e.isMouseEvent())return;if(this.getType()==1){var
Fb=this.getState()==0?1:0;var
M=this.doEvent("jsxtoggle",{objEVENT:e,intSTATE:Fb});if(M!==false){this.setState(Fb);h.childNodes[0].childNodes[0].src=this.r_(false,false);}}this.doEvent("jsxexecute",{objEVENT:e});};n.Wh=function(o,q){q.childNodes[0].childNodes[0].src=this.r_(true,false);};n.gn=function(d,i){i.childNodes[0].childNodes[0].src=this.r_(false,false);};n.Sf=function(h,e){if(h.leftButton())e.childNodes[0].childNodes[0].src=this.r_(false,true);};n.ZY=function(f,g){if(f.rightButton())this.jsxsupermix(f,g);else if(f.leftButton())g.childNodes[0].childNodes[0].src=this.r_(false,false);};n.Rn=function(a,l){if(a.enterKey()||a.spaceKey()){this.Th(a,l);a.cancelAll();}};n.doValidate=function(){var
Ub=null;if(this.getType()==p.NORMAL)Ub=1;else Ub=this.getState()==1||this.getRequired()==0?1:0;this.setValidationState(Ub);return Ub;};n.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};n.emInit=function(f){this.jsxsupermix(f);};n.emSetValue=function(a){};n.emGetValue=function(){return null;};n.emBeginEdit=function(m,b,d,r,l,c,s){var
yc=s.childNodes[0].childNodes[0];if(yc){this.jsxsupermix(m,b,d,r,l,c,s);yc.focus();}else return false;};n.emPaintTemplate=function(){this.setEnabled(0);var
Jb=this.paint();this.setEnabled(1);var
zc=this.paint();return this.To(zc,Jb);};});
