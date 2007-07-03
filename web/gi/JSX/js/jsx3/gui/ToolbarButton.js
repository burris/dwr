/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Form","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.ToolbarButton",jsx3.gui.Block,[jsx3.gui.Form],function(r,d){var
Ob=jsx3.gui.Form;var
z=jsx3.gui.Interactive;var
nc=jsx3.gui.Event;r.TYPENORMAL=0;r.TYPECHECK=1;r.TYPERADIO=2;r.STATEOFF=0;r.STATEON=1;r.IMAGEDOWN=jsx3.resolveURI("jsx:///images/tbb/down.gif");r.IMAGEON=jsx3.resolveURI("jsx:///images/tbb/on.gif");r.IMAGEOVER=jsx3.resolveURI("jsx:///images/tbb/over.gif");r.DEFAULTIMAGE=jsx3.resolveURI("jsx:///images/tbb/default.gif");r.BORDERCOLOR="#9B9BB7";jsx3.html.loadImages(r.IMAGEDOWN,r.IMAGEON,r.IMAGEOVER,r.DEFAULTIMAGE);d.init=function(i,s,l){this.jsxsuper(i,null,null,null,null);if(s!=null)this.setType(s);if(l!=null)this.setTip(l);};d.getDisabledImage=function(){return this.jsxdisabledimage!=null&&jsx3.util.strTrim(this.jsxdisabledimage)!=""?this.jsxdisabledimage:this.getImage();};d.setDisabledImage=function(f){this.jsxdisabledimage=f;return this;};d.doValidate=function(){var
T=this.getType==0||this.getRequired()==0||this.getState()==1;return this.setValidationState(T?1:0).getValidationState();};d.getImage=function(){return this.jsximage!=null&&jsx3.util.strTrim(this.jsximage)!=""?this.jsximage:null;};d.setImage=function(i){this.jsximage=i;return this;};d.getType=function(){return this.jsxtype==null?0:this.jsxtype;};d.setType=function(h){this.jsxtype=h;return this;};d.Rn=function(i,m){if(i.spaceKey()||i.enterKey()){this.XL(i,m);i.cancelAll();}};d.getMaskProperties=function(){return jsx3.gui.Block.MASK_NO_EDIT;};d.Sf=function(e,h){if(!e.leftButton())return;h.style.backgroundImage="url("+r.IMAGEDOWN+")";h.childNodes[3].style.backgroundColor=r.BORDERCOLOR;if(this.getEvent("jsxmenu")!=null)h.childNodes[2].style.backgroundImage="url("+r.IMAGEDOWNMENU+")";};d.ZY=function(p,i){if(p.leftButton()){i.style.backgroundImage="";i.childNodes[3].style.backgroundColor="";}else if(p.rightButton())this.jsxsupermix(p,i);};d.Wh=function(p,n){if(this.getState()==0){n.style.backgroundImage="url("+r.IMAGEOVER+")";n.childNodes[3].style.backgroundColor="#808080";}};d.gn=function(f,g){if(this.getState()==0){g.style.backgroundImage="";g.childNodes[3].style.backgroundColor="";}};d.doExecute=function(n){if(n==null)n=true;this.XL(n,this.getRendered(n instanceof nc?n:null));};d.doClick=function(){this.XL(true,this.getRendered());};d.XL=function(b,k){var
Hc=this.doEvent("jsxexecute",{objEVENT:b instanceof nc?b:null});if(Hc!==false)if(this.getType()==2){this.dz(1,b,k);}else if(this.getType()==1)this.dz(this.getState()==1?0:1,b,k);};d.getGroupName=function(){return this.jsxgroupname!=null&&this.getType()==2?this.jsxgroupname:null;};d.setGroupName=function(a){if(this.getType()==2)this.jsxgroupname=a;return this;};d.getDivider=function(){return this.jsxdivider!=null?this.jsxdivider:0;};d.setDivider=function(f,i){this.jsxdivider=f;if(i)this.recalcBox(["border","padding"]);else this.fi();return this;};d.getState=function(){return this.getType()==0?0:this.jsxstate==null?0:this.jsxstate;};d.setState=function(o){var
Mc=null;Mc=this.isOldEventProtocol();this.dz(o,Mc,this.getRendered());return this;};d.dz=function(l,c,j){var
cc=false;if(this.getType()==2&&l==1){var
wc=this.getGroupName();var
ub=this.getParent().findDescendants(function(f){return f instanceof r&&f.getGroupName()==wc;},false,true,true);for(var
Vb=ub.length-1;Vb>=0;Vb--)if(ub[Vb]!=this&&ub[Vb].getType()==2){ub[Vb].jsxstate=0;var
Wb=ub[Vb].getRendered(j);if(Wb!=null){Wb.style.backgroundImage="";Wb.childNodes[3].style.backgroundColor="";if(ub[Vb].getEvent("jsxmenu")!=null)Wb.childNodes[2].style.backgroundImage="url("+r.IMAGEOFFMENU+")";}}else if(ub[Vb]==this)if(j!=null){j.style.backgroundImage="url("+r.IMAGEON+")";j.childNodes[3].style.backgroundColor=r.BORDERCOLOR;if(this.getEvent("jsxmenu")!=null)j.childNodes[2].style.backgroundImage="url("+r.IMAGEONMENU+")";}cc=true;}else if(this.getType()==2){if(j!=null){j.style.backgroundImage="";j.childNodes[3].style.backgroundColor="";if(this.getEvent("jsxmenu")!=null)j.childNodes[2].style.backgroundImage="url("+r.IMAGEOFFMENU+")";}cc=true;}else if(this.getType()==1){if(j!=null)if(l==1){j.style.backgroundImage="url("+r.IMAGEON+")";j.childNodes[3].style.backgroundColor=r.BORDERCOLOR;if(this.getEvent("jsxmenu")!=null)j.childNodes[2].style.backgroundImage="url("+r.IMAGEONMENU+")";}else{j.style.backgroundImage="";j.childNodes[3].style.backgroundColor="";if(this.getEvent("jsxmenu")!=null)j.childNodes[2].style.backgroundImage="url("+r.IMAGEOFFMENU+")";}cc=true;}this.jsxstate=l;if(cc&&c){var
Jc=null;if(c instanceof nc)Jc={objEVENT:c};this.doEvent("jsxchange",Jc);}return this;};d.setEnabled=function(f,p){if(this._jsxhotkey!=null)this._jsxhotkey.setEnabled(f==1);return this.jsxsupermix(f,p);};r.Tk={};r.Tk["click"]="XL";r.Tk["keydown"]=true;r.Tk["mousedown"]=true;r.Tk["mouseup"]=true;r.Tk["mouseout"]=true;r.Tk["mouseover"]=true;r.Tk["blur"]="gn";r.Tk["focus"]="Wh";d.Vd=function(b,e,p){this.Qh(b,e,p,3);};d.zj=function(){var
pc=this.getRelativePosition()!=0;var
vc,mc,Ac;var
sb={};sb.height=22;if(pc){sb.margin=(vc=this.getMargin())!=null&&vc!=""?vc:"1 4 1 0";sb.tagname="span";sb.boxtype="relativebox";}else{sb.left=(mc=this.getLeft())!=null&&mc!=""?mc:0;sb.top=(Ac=this.getTop())!=null&&Ac!=""?Ac:0;sb.tagname="div";sb.boxtype="box";}if(this.getDivider()==1){sb.padding="0 0 0 4";sb.border="0px;0px;0px;solid 1px "+r.BORDERCOLOR;}var
Y=new
jsx3.gui.Painted.Box(sb);sb={};sb.width=this.getImage()!=null&&this.getImage()!=""?22:3;sb.height=22;sb.tagname="span";sb.boxtype="relativebox";var
Cc=new
jsx3.gui.Painted.Box(sb);Y.Od(Cc);sb={};if(jsx3.util.strEmpty(this.getText())){sb.width=1;}else sb.padding="5 4 5 0";sb.height=22;sb.tagname="span";sb.boxtype="relativebox";var
L=new
jsx3.gui.Painted.Box(sb);Y.Od(L);sb={};sb.width=1;sb.height=22;sb.tagname="span";sb.boxtype="relativebox";var
oc=new
jsx3.gui.Painted.Box(sb);Y.Od(oc);sb={};sb.width=1;sb.height=22;sb.tagname="span";sb.boxtype="relativebox";var
Jc=new
jsx3.gui.Painted.Box(sb);Y.Od(Jc);return Y;};d.paint=function(){this.applyDynamicProperties();var
Kb;if((Kb=this.getKeyBinding())!=null){var
Pb=this;if(this._jsxhotkey!=null)this._jsxhotkey.destroy();this._jsxhotkey=this.doKeyBinding(function(i){Pb.XL(i,Pb.getRendered());},Kb);this._jsxhotkey.setEnabled(this.getEnabled()!=0);}var
Mb=this.getState()==1?"background-image:url("+r.IMAGEON+");":"";var
V=this.Af();var
lb=this.Dh();var
yc=null,Q=null,Hc=null;if(this.getEnabled()==1){yc=this.qk(r.Tk,0);Q=this.getUriResolver().resolveURI(this.getImage());Hc="";}else{yc="";Q=this.getUriResolver().resolveURI(this.getDisabledImage());Hc=jsx3.html.getCSSOpacity(0.4);}var
mc=this.renderAttributes(null,true);var
Ac=this.vi(true);Ac.setAttributes("id='"+this.getId()+"' "+"label='"+this.getName()+"' "+this.vo()+this.fo()+yc+" class='jsx30toolbarbutton'"+mc);Ac.setStyles(this.Nh()+Mb+V+lb+Hc+this.vl()+this.ji());var
O=Ac.tp(0);O.setStyles("overflow:hidden;"+(Q!=null?"background-image:url("+Q+");":""));O.setAttributes("class='jsx30toolbarbutton_img' unselectable='on'");var
ab=Ac.tp(1);ab.setAttributes("class='jsx30toolbarbutton_lbl' unselectable='on'");var
G;if((G=this.getText())!=null&&G!=""){ab.setStyles(this.Eo()+this.Ak()+this.xp()+this.Wm());}else{G="&#160;";ab.setStyles("overflow:hidden;");}var
Kc=Ac.tp(2);Kc.setAttributes("class='jsx30toolbarbutton_cap'");var
qc=Ac.tp(3);qc.setAttributes("class='jsx30toolbarbutton_cap'");qc.setStyles("overflow:hidden;"+(this.getState()==1?"background-color:"+r.BORDERCOLOR+";":""));return Ac.paint().join(O.paint().join("&#160;")+ab.paint().join(G)+Kc.paint().join("&#160;")+qc.paint().join("&#160;"));};d.Nh=function(){return this.getEnabled()==1?"cursor:pointer;":"cursor:default;";};r.getVersion=function(){return "3.0.00";};d.emGetType=function(){return jsx3.gui.Matrix.EditMask.FORMAT;};d.emInit=function(m){this.jsxsupermix(m);if(this.getType()==2)this.setType(0);this.subscribe("jsxexecute",this,"CN");};d.emSetValue=function(e){};d.emGetValue=function(){return null;};d.emBeginEdit=function(c,l,a,h,e,k,j){var
ec=j.childNodes[0].childNodes[0];if(ec){this.jsxsupermix(c,l,a,h,e,k,j);ec.focus();}else return false;};d.emPaintTemplate=function(){this.setEnabled(0);var
Ac=this.paint();this.setEnabled(1);var
Pb=this.paint();return this.To(Pb,Ac);};d.CN=function(o){var
Hb=this.emGetSession();if(Hb){}};});jsx3.ToolbarButton=jsx3.gui.ToolbarButton;
