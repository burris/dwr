/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Button",jsx3.gui.Block,[jsx3.gui.Form],function(r,b){var
zc=jsx3.gui.Event;var
Gc=jsx3.gui.Form;r.DEFAULTBACKGROUNDCOLOR="#e8e8f5";r.DEFAULTHIGHLIGHT="#f6f6ff";r.DEFAULTSHADOW="#a6a6af";r.DEFAULTHEIGHT=17;b._jsxT0=null;r.DEFAULTCLASSNAME="jsx30button";b.init=function(k,h,d,f,c){this.jsxsuper(k,h,d,f);this.setText(c);};b.doValidate=function(){return this.setValidationState(1).getValidationState();};b.Rn=function(i,d){if(i.spaceKey()||i.enterKey()){this.XL(i,d);i.cancelAll();}};b.doClick=function(){var
kb=zc.getCurrent();this.XL(kb);};b.focus=function(){var
J=this.getRendered();if(J){J=J.childNodes[0];J.focus();return J;}};b.doExecute=function(a){this.XL(a);};b.XL=function(q,o){if(q==null||q.leftButton()||!q.isMouseEvent())this.doEvent("jsxexecute",{objEVENT:q});};b.Sf=function(s,m){if(!s.leftButton())return;if(!this.getBorder()){m.style.border="solid 1px "+r.DEFAULTSHADOW;m.style.borderRightColor=r.DEFAULTHIGHLIGHT;m.style.borderBottomColor=r.DEFAULTHIGHLIGHT;}m.childNodes[0].focus();};b.ZY=function(e,h){if(e.leftButton())if(!this.getBorder()){h.style.border="solid 1px "+r.DEFAULTHIGHLIGHT;h.style.borderRightColor=r.DEFAULTSHADOW;h.style.borderBottomColor=r.DEFAULTSHADOW;}this.jsxsupermix(e,h);};b.gn=function(q,o){if(!this.getBorder()){o.style.border="solid 1px "+r.DEFAULTHIGHLIGHT;o.style.borderRightColor=r.DEFAULTSHADOW;o.style.borderBottomColor=r.DEFAULTSHADOW;}};b.getValue=function(){return this.getText();};b.setEnabled=function(l,o){if(this._jsxT0!=null)this._jsxT0.setEnabled(l==1);return this.jsxsupermix(l,o);};r.Tk={};r.Tk["click"]="XL";r.Tk["keydown"]=true;r.Tk["mousedown"]=true;r.Tk["mouseup"]=true;r.Tk["mouseout"]=true;b.Vd=function(f,c,l){var
Mc=this.vi(true,f);if(c){var
Fc=Mc.recalculate(f,c,l);if(Fc.w||Fc.h){var
Kb=Mc.tp(0);Kb.recalculate({parentwidth:Mc.Si(),parentheight:Mc.Zh()},c.childNodes[0],l);}}};b.zj=function(g){this.applyDynamicProperties();if(this.getParent()&&(g==null||isNaN(g.parentwidth)||isNaN(g.parentheight))){g=this.getParent().Ln(this);}else if(g==null)g={};g.tagname="span";if(g.width==null&&!jsx3.util.strEmpty(this.getWidth()))g.width=this.getWidth();g.height=this.getHeight()==null?r.DEFAULTHEIGHT:this.getHeight();if(this.getRelativePosition()!=0){g.boxtype="relativebox";if(!jsx3.util.strEmpty(this.getMargin()))g.margin=this.getMargin();}else{g.boxtype="box";g.left=!jsx3.util.strEmpty(this.getLeft())?this.getLeft():0;g.top=!jsx3.util.strEmpty(this.getTop())?this.getTop():0;}g.padding=!jsx3.util.strEmpty(this.getPadding())?this.getPadding():"2";g.border=this.getBorder()||"solid 1px "+r.DEFAULTHIGHLIGHT+";solid 1px "+r.DEFAULTSHADOW+";solid 1px "+r.DEFAULTSHADOW+";solid 1px "+r.DEFAULTHIGHLIGHT;var
Lc=new
jsx3.gui.Painted.Box(g);var
mc={};mc.parentwidth=Lc.Si();mc.parentheight=Lc.Zh();mc.height="100%";if(g.width){mc.width="100%";mc.tagname="div";mc.boxtype="inline";}else{mc.tagname="span";mc.boxtype="relativebox";}var
jb=new
jsx3.gui.Painted.Box(mc);Lc.Od(jb);return Lc;};b.paint=function(){this.applyDynamicProperties();var
Y;if((Y=this.getKeyBinding())!=null){var
dc=this;if(this._jsxT0!=null)this._jsxT0.destroy();this._jsxT0=this.doKeyBinding(function(g){dc.XL(g);},Y);this._jsxT0.setEnabled(this.getEnabled()!=0);}var
vb=this.qk(this.getEnabled()==1?r.Tk:null,0);var
Jb=this.renderAttributes(null,true);var
N=this.vi(true);N.setAttributes('id="'+this.getId()+'"'+this.so()+this.fo()+vb+' class="'+this.Wg()+'" unselectable="on" '+Jb);N.setStyles(this.Af()+this.Dh()+this.Nh()+this.xp()+this.Ak()+this.Wm()+this.Eo()+this.Dg()+this.vl()+this.Ho()+this.ji());var
ic=N.tp(0);ic.setAttributes(this.vo()+' class="jsx30button_text" unselectable="on" ');ic.setStyles(this.Ho());return N.paint().join(ic.paint().join(this.im())+this.paintChildren());};b.Dg=function(){var
A=this.getEnabled()!=0?this.getBackgroundColor()||r.DEFAULTBACKGROUNDCOLOR:this.getDisabledBackgroundColor()||Gc.DEFAULTDISABLEDBACKGROUNDCOLOR;return "background-color:"+A+";";};b.Nh=function(){return this.getEnabled()==1?"cursor:pointer;":"cursor:default;";};b.Wg=function(){var
K=this.getClassName();return r.DEFAULTCLASSNAME+(K?" "+K:"");};r.getVersion=function(){return "3.0.00";};b.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};b.emInit=function(l){this.jsxsupermix(l);this.subscribe("jsxexecute",this,"CN");};b.emSetValue=function(p){};b.emGetValue=function(){return null;};b.emBeginEdit=function(m,k,d,i,l,c,s){var
jb=jsx3.html.selectSingleElm(s,0,0,0);if(jb){this.jsxsupermix(m,k,d,i,l,c,s);jb.focus();}else return false;};b.emPaintTemplate=function(){this.setEnabled(0);var
Sb=this.paint();this.setEnabled(1);var
bb=this.paint();return this.To(bb,Sb);};b.CN=function(o){var
Q=this.emGetSession();if(Q){}};});jsx3.Button=jsx3.gui.Button;
