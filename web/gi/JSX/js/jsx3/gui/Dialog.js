/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Alerts","jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Dialog",jsx3.gui.Block,[jsx3.gui.Alerts],function(b,r){var
Eb=jsx3.gui.Event;var
Jb=jsx3.gui.Interactive;var
sc=jsx3.util.Logger.getLogger(b.jsxclass.getName());b.MINIMIZED=0;b.MAXIMIZED=1;b.DEFAULTBACKGROUNDCOLOR="#e8e8f5";b.FIXED=0;b.RESIZEABLE=1;b.RESIZABLE=1;b._H=jsx3.resolveURI("jsx:///images/dialog/window.gif");b.ww=jsx3.resolveURI("jsx:///images/dialog/close.gif");b.Jw=jsx3.resolveURI("jsx:///images/dialog/min.gif");b.lY=jsx3.resolveURI("jsx:///images/dialog/resize.gif");b.MODAL=1;b.NONMODAL=0;b.GW="JSX/images/dialog/max.gif";b.sS="JSX/images/dialog/restore.gif";b.cS=[null,32,32,32];b.IS=[10,10,10,10];b.aO=10;b.AE="JSXTBB_";r.init=function(q,o,l,m){this.jsxsuper(q,null,null,o,l);jsx3.require("jsx3.gui.WindowBar","jsx3.gui.ToolbarButton");var
Fb=new
jsx3.gui.WindowBar(q+"_cbar");if(m!=null)Fb.setText(m);this.setChild(Fb,1,null,"JSXFRAG");var
J=new
jsx3.gui.ToolbarButton(this.getName()+"_btn_min",null);J.setEvent("this.getParent().getParent().doToggleState();","jsxexecute");J.setDynamicProperty("jsximage","@Min Icon");J.setDynamicProperty("jsxtip","@Min Tip");Fb.setChild(J,1,null,"JSXFRAG");J=new
jsx3.gui.ToolbarButton(this.getName()+"_btn_close",null);J.setEvent("this.getParent().getParent().doClose();","jsxexecute");J.setDynamicProperty("jsximage","@Close Icon");J.setDynamicProperty("jsxtip","@Close Tip");Fb.setChild(J,1,null,"JSXFRAG");};r.onAfterAssemble=function(m,o){if(this.getWindowState()==1)this.setZIndex(o.getNextZIndex(jsx3.app.Server.Z_DIALOG));};r.getMaskProperties=function(){return this.getModal()==0?jsx3.gui.Block.MASK_ALL_EDIT:jsx3.gui.Block.MASK_NO_EDIT;};r.doToggleState=function(n){var
Fc=n!=null?n:this.getWindowState()==1?0:1;var
M;if((M=this.getTaskButton())!=null){this.setWindowState(Fc);var
sb=null;if(Fc==1){this.setDisplay("",true);this.setZIndex(this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG)*this.getZMultiplier(),true);sb=this;}else{this.setDisplay("none",true);sb=M;}M.setState(Fc==1?1:0);sb.focus();}else{var
Gc=this.NL();if(Fc==1){this.setWindowState(1);var
_=this.vi(true);Gc.style.height=_.Ae()+"px";Gc.childNodes[2].style.height=_.Ae()+"px";Gc.childNodes[1].style.display="";if(this.getResize()){Gc.childNodes[3].style.display="";Gc.childNodes[4].style.display="";}this.setZIndex(this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG)*this.getZMultiplier(),true);}else{this.setWindowState(0);Gc.childNodes[1].style.display="none";var
_=this.vi(true);var
ec=_.Fg()-_.Ae();Gc.style.height=32-ec+"px";Gc.childNodes[2].style.height=32-ec+"px";if(this.getResize()){Gc.childNodes[3].style.display="none";Gc.childNodes[4].style.display="none";}}}};r.setDisplay=function(e,i){this.jsxdisplay=e;if(i)this.updateGUI("display",e);return this;};r.updateGUI=function(s,c){var
fc=this.NL();if(fc!=null)try{fc.style[s]=c;}catch(Kc){}};r.focus=function(i){if(!i){jsx3.sleep(function(){this.focus(true);},"focus"+this.getId(),this);return;}var
S=this.NL();if(!S)return;if(this.getWindowState()==0){if(this.getTaskButton())this.doToggleState(1);else this.NL().focus();}else{var
hc=jsx3.app.Browser.isTableMoveBroken();if(hc)S.childNodes[1].style.display="none";this.setZIndex(this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG),true);var
V=this.getCaptionBar();if(V!=null)V.focus();else this.NL().focus();if(hc)S.childNodes[1].style.display="";}};r.isFront=function(){if(this.getWindowState()==0)return false;var
ac=this.getParent();var
F=ac.getDescendantsOfType(b,true);for(var
Kc=0;Kc<F.length;Kc++)if(F[Kc]!=this&&F[Kc].getWindowState()==1&&F[Kc].getZIndex()>this.getZIndex())return false;return true;};r.QF=function(q,o){if(!this.isFront()){var
Nc=this.Kz();var
Gc=Nc.style.display;var
Fb=jsx3.app.Browser.isTableMoveBroken();if(Gc!="none"&&Fb)Nc.style.display="none";this.setZIndex(this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG),true);if(Gc!="none"&&Fb)Nc.style.display=Gc;}};r.Kz=function(){var
Db=this.NL();return Db!=null?Db.childNodes[1]:null;};r.getTaskButton=function(l){if(l==null){var
Lc=this.getServer();if(Lc!=null)l=Lc.getTaskBar();}if(l!=null)return l.getChild(b.AE+this.getId());return null;};r.paintChild=function(p,l){var
Ob=this.NL();if(Ob!=null)if(this.getCaptionBar()==p){this.repaint();}else this.jsxsuper(p,l,Ob.childNodes[1]);};r.doClose=function(){this.getParent().removeChild(this);};r.onSetParent=function(n){var
Db=this.getServer();if(Db!=null&&Db!=n.getServer())this.ZS(Db);return true;};r.onSetChild=function(n){this.jsxsuper(n);if(!this.getCaptionBar()&&b.vQ(n))this.qo(true);return true;};r.ZS=function(e){if(e==null)e=this.getServer();var
kc=this.getTaskButton(e.getTaskBar());if(kc!=null)kc.getParent().removeChild(kc);};r.onDestroy=function(c){this.ZS(c.getServer());this.jsxsuper(c);};r.getWindowState=function(){return this.jsxwindowstate!=null?this.jsxwindowstate:1;};r.setWindowState=function(h){this.jsxwindowstate=h;return this;};r.getZMultiplier=function(){return this.jsxzmultiplier!=null?this.jsxzmultiplier:1;};r.setZMultiplier=function(k){this.jsxzmultiplier=k;return this;};r.getModal=function(){return this.jsxmodal!=null?this.jsxmodal:0;};r.setModal=function(h){this.jsxmodal=h;return this;};r.doBeginMove=function(q,o){if(q.leftButton()){this._jsxaC=true;var
Sb=this.NL();var
wc=Sb.childNodes[2];wc.style.visibility="";Sb.childNodes[0].focus();try{this.jsxsupermix(q,wc);Eb.subscribe("mouseup",this,"doEndMove");this.setZIndex(this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG),true);}catch(Kc){var
lb=jsx3.lang.NativeError.wrap(Kc);sc.error("BeforeMove model event error for the control, "+this.getName()+".\nDescription:\n"+lb);this.B1(wc);}}};r.B1=function(f){f.style.visibility="hidden";f.style.left="-1px";f.style.top="-1px";this._jsxaC=false;Eb.unsubscribe("mouseup",this,"doEndMove");};r.doEndMove=function(d){if(this._jsxaC){var
I=this.NL();var
kb=I.childNodes[2];I.style.left=parseInt(parseInt(I.style.left)+parseInt(kb.style.left)+1)+"px";I.style.top=parseInt(parseInt(I.style.top)+parseInt(kb.style.top)+1)+"px";this.B1(kb);d=d.event;if(I.ownerDocument.getElementsByTagName("body")[0]){try{this.jsxsupermix(d,I);}catch(Kc){var
xc=jsx3.lang.NativeError.wrap(Kc);sc.error("AfterMove model event error for the control, "+this.getName()+".\nDescription:\n"+xc);}if(!this.getEvent("jsxaftermove"))this.constrainPosition();}else sc.error("doEndMove: "+jsx3.html.getOuterHTML(d.srcElement()));}this.focus(true);};r.NL=function(){var
hc=this.getRendered();if(hc!=null&&this.jsxmodal){return hc.childNodes[1];}else return hc;};r.getAbsolutePosition=function(q){return this.jsxsuper(q,this.NL());};r.setLeft=function(p,s){this.jsxleft=p;if(s){this.wZ({left:p});}else this.fi();return this;};r.setTop=function(l,s){this.jsxtop=l;if(s){this.wZ({top:l});}else this.fi();return this;};r.setWidth=function(q,o){this.jsxwidth=q;if(o){this.wZ({width:this.jsxwidth});}else this.fi();return this;};r.setHeight=function(l,h){this.jsxheight=l;if(h){this.wZ({height:this.jsxheight});}else this.fi();return this;};r.doMaximize=function(s){if(this.getWindowState()==0)this.doToggleState(1);if(this._jsxAX!=null){var
U=this.BL(this._jsxAX.jsxwidth,this._jsxAX.jsxheight);this.jsxwidth=U[0];this.jsxheight=U[1];this.jsxleft=this._jsxAX.jsxleft;this.jsxtop=this._jsxAX.jsxtop;delete this._jsxAX;var
Cb={left:this.getLeft(),top:this.getTop(),width:this.getWidth(),height:this.getHeight()};this.wZ(Cb,true);if(s)s.setDynamicProperty("jsxtip","@Max Tip").setImage(b.GW).repaint();}else{this._jsxAX={};this._jsxAX.jsxwidth=this.getWidth();this._jsxAX.jsxheight=this.getHeight();this._jsxAX.jsxtop=this.getTop();this._jsxAX.jsxleft=this.getLeft();var
Lc=this.getParent().getAbsolutePosition();var
Cc=this.NL();var
U=this.BL(Lc.W-b.IS[1]-b.IS[3],Lc.H-b.IS[0]-b.IS[2]);this.jsxwidth=U[0];this.jsxheight=U[1];this.jsxleft=Math.min(parseInt(Cc.style.left),Lc.W-this.jsxwidth-b.IS[1]);this.jsxtop=Math.min(parseInt(Cc.style.top),Lc.H-this.jsxheight-b.IS[2]);var
Cb={left:this.getLeft(),top:this.getTop(),width:this.getWidth(),height:this.getHeight()};this.wZ(Cb,true);if(s)s.setDynamicProperty("jsxtip","@Restore Tip").setImage(b.sS).repaint();}};r.getResize=function(){return this.jsxresize==null?1:this.jsxresize;};r.setResize=function(j){this.jsxresize=j;this.fi();return this;};r.setResizeParameters=function(k,i,j,c,d,f){this.jsxresize=k;this.jsxminx=i;this.jsxminy=j;this.jsxmaxx=c;this.jsxmaxy=d;};r.BL=function(k,f){k=Math.max(k,this.gx());f=Math.max(f,this.bS());if(typeof this.jsxmaxx=="number")k=Math.min(k,this.jsxmaxx);if(typeof this.jsxmaxy=="number")f=Math.min(f,this.jsxmaxy);return [k,f];};r.getCaptionBar=function(){return this.findDescendants(b.vQ,false,false,true);};b.vQ=function(j){return jsx3.gui.WindowBar&&j instanceof jsx3.gui.WindowBar&&j.getType()==0;};r.e3=function(m,s){if(!m.leftButton())return;var
_=this.doEvent("jsxbeforeresize",{objEVENT:m});if(_!==false){b._jsxFG=s.parentNode.childNodes[2];b._jsxFG.style.visibility="";b._jsxFG.style.zIndex=11;s.style.zIndex=12;var
D=this.vi(true).tp(1);b._jsxoffx=b.aO+2;b._jsxoffy=b.aO+2;var
Hb=this;jsx3.gui.Interactive.ll(m,s,function(e,d){return Hb.UI(e,d);});Eb.subscribe("mouseup",this,"DJ");}};r.UI=function(m,l){if(b._jsxFG){this._jsxe8=m+b._jsxoffx;this._jsxW3=l+b._jsxoffy;this._jsxe8=Math.max(this._jsxe8,this.gx());this._jsxW3=Math.max(this._jsxW3,this.bS());if(typeof this.jsxmaxx=="number")this._jsxe8=Math.min(this._jsxe8,this.jsxmaxx);if(typeof this.jsxmaxy=="number")this._jsxW3=Math.min(this._jsxW3,this.jsxmaxy);var
ib=this.vi().tp(1);ib.recalculate({width:this._jsxe8,height:this._jsxW3},b._jsxFG);return [this._jsxe8-b._jsxoffx,this._jsxW3-b._jsxoffy];}return [m,l];};r.gx=function(){var
Hb=Number(this.jsxminx)||-1;return Math.max(25,Hb);};r.bS=function(){var
z=Number(this.jsxminy)||-1;var
Xb=15;if(this.getCaptionBar()!=null)Xb=Xb+30;return Math.max(Xb,z);};r.DJ=function(j){j=j.event;Eb.unsubscribe("mouseup",this,"DJ");Eb.publish(j);if(!b._jsxFG)return;var
Nb=this.vi().tp(1);var
wb=Nb.Ll();var
nb=Nb.Fg();b._jsxFG.style.visibility="hidden";b._jsxFG.style.zIndex=0;delete b._jsxFG;this.jsxwidth=wb;this.jsxheight=nb;this.wZ({width:wb,height:nb});this.doEvent("jsxafterresize",{objEVENT:j});};r.recalcBox=function(){this.jsxsuper();this.wZ();};r.Ln=function(g){var
X=g==this.getCaptionBar()?this.vi(true):this.vi(true).tp(0);return {parentwidth:X.Si(),parentheight:X.Zh()};};r.wZ=function(n,i){if(i&&(n.left==null||n.top==null)){var
Sb=this.getParent().getAbsolutePosition();if(n.left==null)n.left=Math.max(0,parseInt((Sb.W-n.width)/2));if(n.top==null)n.top=Math.max(0,parseInt((Sb.H-n.height)/2));}this.Ch(n,true);};r.zj=function(o){var
K=this.getWindowState()==0&&this.getServer().getTaskBar()==null;var
Y=this.getParent();if(Y==null){Y={H:this.getHeight(),W:this.getWidth()};}else{Y=Y.getAbsolutePosition();if(Y==null||Y.W==0)Y={H:this.getHeight(),W:this.getWidth()};}var
oc=jsx3.util.strEmpty(this.getTop())?Math.max(0,parseInt((Y.H-this.getHeight())/2)):this.getTop();var
B=jsx3.util.strEmpty(this.getLeft())?Math.max(0,parseInt((Y.W-this.getWidth())/2)):this.getLeft();if(o==null)o={};if(o.left==null)o.left=B;if(o.top==null)o.top=oc;if(o.width==null)o.width=this.getWidth();if(o.height==null)o.height=K?30:this.getHeight();o.tagname="div";o.boxtype="box";o.padding="2 2 2 2";o.border="1px pseudo";var
Pb=new
jsx3.gui.Painted.Box(o);var
fc=this.getCaptionBar();var
R={};R.parentwidth=Pb.Si();R.parentheight=Pb.Zh();R.width="100%";R.height=this.getHeight()-(fc!=null?fc.getHeight()+8:6);R.top=fc!=null?fc.getHeight()+4:2;R.left=2;R.tagname="div";R.boxtype="box";R.border="1px pseudo";var
ec=new
jsx3.gui.Painted.Box(R);Pb.Od(ec);R={};R.left=-1;R.top=-1;R.width=this.getWidth();R.height=K?30:this.getHeight();R.tagname="div";R.boxtype="box";R.padding="0";R.border="1px pseudo";var
U=new
jsx3.gui.Painted.Box(R);Pb.Od(U);R={};R.left=this.getWidth()-(b.aO+2);R.top=this.getHeight()-(b.aO+2);R.width=b.aO+1;R.height=b.aO+1;R.tagname="div";R.boxtype="box";var
y=new
jsx3.gui.Painted.Box(R);Pb.Od(y);R={};R.left=this.getWidth()-(b.aO+2);R.top=this.getHeight()-(b.aO+2);R.width=b.aO;R.height=b.aO;R.tagname="div";R.boxtype="box";var
Kc=new
jsx3.gui.Painted.Box(R);Pb.Od(Kc);return Pb;};r.Vd=function(l,i,f){var
Gb=this.vi(true,l);if(i!=null)i=this.NL();if(i!=null){var
Ib=this.getCaptionBar();var
Kb=Gb.recalculate(l,i,f);if(!Kb.w&&!Kb.h)return;var
H=Gb.tp(0);var
w=this.getHeight()-(Ib!=null?Ib.getHeight()+8:6);H.recalculate({parentwidth:Gb.Si(),parentheight:Gb.Zh(),width:"100%",height:w},i.childNodes[1],f);var
mc=Gb.tp(1);mc.recalculate({width:this.getWidth(),height:this.getHeight()},i.childNodes[2],f);if(this.getResize()==1){var
oc=Gb.tp(2);oc.recalculate({top:this.getHeight()-(b.aO+2),left:this.getWidth()-(b.aO+2)},i.childNodes[3],f);var
Bc=Gb.tp(3);Bc.recalculate({top:this.getHeight()-(b.aO+2),left:this.getWidth()-(b.aO+2)},i.childNodes[4],f);}if(Ib)f.add(Ib,{width:"100%",parentwidth:Gb.Si(),height:Ib.getHeight()},i.childNodes[0],true);var
fb=this.getChildren();var
yc=0;var
cb=i.childNodes[Ib?1:0];if(cb){var
ac=cb.childNodes;for(var
bb=0;bb<fb.length;bb++)if(fb[bb]!=Ib){f.add(fb[bb],{parentwidth:H.Si(),parentheight:H.Zh()},true,true);}else yc=1;}}};r.paint=function(){this.applyDynamicProperties();var
ab=this.getId();var
Yb=this.getWindowState()==0&&this.getServer().getTaskBar()==null;var
t=Yb?"display:none;":"";var
oc=this.getServer()!=null?this.getServer().getNextZIndex(jsx3.app.Server.Z_DIALOG)*this.getZMultiplier():5000;var
Ac={};if(this.getEvent("jsxkeypress")!=null)Ac["keypress"]=true;if(this.getModal()!=1)Ac["mousedown"]="QF";var
kc=this.getModal()==1;var
zc=this.qk(Ac,kc?1:0);var
Ic=this.renderAttributes(null,true);this.Ce();var
Gb=this.vi(true);if(Yb){var
Mc=Gb.Fg()-Gb.Ae();var
qb="height:"+(32-Mc)+"px;";}else var
qb="";if(kc){var
_b=['<div id="'+ab+'" '+this.vo()+this.cn("keydown","jY",0)+' style="width:100%;height:100%;position:absolute;left:0px;top:0px;z-index:'+oc+this.Af()+';"'+">"+'<div class="jsx30dialog_modal"'+this.cn("mousedown","xZ",1)+this.cn("mouseup","Qr",1)+">&#160;</div>","<span "+this.vo()+this.cn("keydown","jY",1)+' style="position:absolute;left:-1px;top:0px;width:1px;height:1px;overflow:hidden;"></span></div>'];Gb.setAttributes('label="'+this.getName()+'"'+zc+this.vo()+' class="'+this.Wg()+'" '+Ic);Gb.setStyles("z-index:1;"+this.Dg()+this.mg()+this.Dh()+this.ji()+qb);}else{var
_b=["",""];Gb.setAttributes('id="'+ab+'"'+this.so()+zc+this.vo()+' class="'+this.Wg()+'" '+Ic);Gb.setStyles("z-index:"+oc+";"+this.Dg()+this.mg()+this.Af()+this.Dh()+this.ji()+qb);}var
C=this.getCaptionBar();var
dc=C!=null?C.paint():"<span style='display:none;'>&#160;</span>";var
fc=Gb.tp(0);fc.setAttributes('class="jsx30dialog_content"');fc.setStyles(this.Ho()+this.Oo()+t);var
qc=this.getChildren().filter(function(j){return j!=C;});var
wb=this.paintChildren(qc);var
Lc=Gb.tp(1);Lc.setAttributes('class="jsx30dialog_mask"');Lc.setStyles("overflow:hidden;visibility:hidden;"+qb);if(this.getResize()==1){var
yb=Gb.tp(2);yb.setStyles("overflow:hidden;cursor:se-resize;z-index:12;background-image:url("+jsx3.gui.Block.SPACE+");"+t);yb.setAttributes(this.cn("mousedown","e3",kc?2:1));var
eb=Gb.tp(3);eb.setStyles("overflow:hidden;z-index:1;background-image:url("+b.lY+");"+t);var
Pb=yb.paint().join("")+eb.paint().join("");}else var
Pb="";return _b[0]+Gb.paint().join(dc+fc.paint().join(wb)+Lc.paint().join("&#160;")+Pb)+_b[1];};r.jY=function(l,a){if(l.srcElement()==a&&l.tabKey()){l.cancelReturn();(this.getCaptionBar()||this).focus();}else l.setAttribute("jsxmodal",1);};r.xZ=function(d,i){this.beep().focus();d.cancelBubble();};r.Qr=function(k,a){this.focus();k.cancelBubble();};r.Ce=function(){var
jc=this.getId();var
eb;if(this.getServer()!=null&&(eb=this.getServer().getTaskBar())!=null&&this.getModal()!=1){var
O=this.getCaptionBar();var
u=this.getTaskButton();if(O!=null){if(u==null){O.applyDynamicProperties();jsx3.require("jsx3.gui.ToolbarButton");var
ib=new
jsx3.gui.ToolbarButton(b.AE+jc,1,O.getText());eb.setChild(ib);ib.setEvent("var d = jsx3.GO('"+jc+"'); d.doToggleState(d.isFront() ? jsx3.gui.Dialog.MINIMIZED : jsx3.gui.Dialog.MAXIMIZED); false;","jsxexecute");ib.setState(this.getWindowState()==1?1:0);ib.setText(jsx3.util.strTruncate(O.getText()||"",20));ib.setImage(b._H);if(eb.getRendered()==null){jsx3.sleep(eb.repaint,"repaint"+eb.getId(),eb);}else eb.paintChild(ib);}else u.setText(jsx3.util.strTruncate(O.getText(),20)).repaint();}else if(u!=null)u.getParent().removeChild(u);}};r.vo=function(){return this.jsxsuper(this.getIndex()||Number(0));};r.Oo=function(){if(this.getOverflow()==2){return "overflow:hidden;";}else return "overflow:auto;";};r.Wg=function(){var
Kc=this.getClassName();return "jsx30dialog"+(Kc?" "+Kc:"");};r.getAlertsParent=function(){return this;};r.constrainPosition=function(s){var
C=this.getRendered();var
Wb=C!=null;var
x=null;if(C){x=C.parentNode;}else if(this.getParent())x=this.getParent().getRendered();if(x==null)return;var
w=parseInt(x.style.width);var
Gc=parseInt(x.style.height);if(s===true){var
Bc=w-b.IS[1]-b.IS[3];var
db=Gc-b.IS[0]-b.IS[2];if(this.getWidth()>Bc)this.setWidth(Bc,Wb);if(this.getHeight()>db)this.setHeight(db,Wb);var
L=w-this.getWidth()-b.IS[1];var
oc=Gc-this.getHeight()-b.IS[2];if(this.getLeft()<b.IS[3])this.setLeft(b.IS[3],Wb);else if(this.getLeft()>L)this.setLeft(L,Wb);if(this.getTop()<b.IS[0])this.setTop(b.IS[0],Wb);else if(this.getTop()>oc)this.setTop(oc,Wb);}else{var
Bb=this.getDimensions();if(!s)s=b.cS;s=s.concat();if(s[0]==null)s[0]=Bb[3];else if(s[0]<0)s[0]=Bb[3]+s[0];if(s[1]==null)s[1]=Bb[2];else if(s[1]<0)s[1]=Bb[2]+s[1];if(s[2]==null)s[2]=Bb[3];else if(s[2]<0)s[2]=Bb[3]+s[2];if(s[3]==null)s[3]=Bb[2];else if(s[3]<0)s[3]=Bb[2]+s[3];if(Bb[0]<s[3]-Bb[2])this.setLeft(s[3]-Bb[2],Wb);else if(Bb[0]>w-s[1])this.setLeft(w-s[1],Wb);if(Bb[1]<s[0]-Bb[3])this.setTop(s[0]-Bb[3],Wb);else if(Bb[1]>Gc-s[2])this.setTop(Gc-s[2],Wb);}};r.onRemoveChild=function(f,l){this.jsxsuper(f,l);if(f instanceof Array){this.fi();this.repaint();}else if(b.vQ(f)){this.fi();this.repaint();}};r.beep=function(){var
t=this.getCaptionBar();if(t!=null){t.beep();}else{var
Db=this.NL();jsx3.gui.po(Db,{backgroundColor:"#FFFFFF"});}return this;};r.getAlwaysCheckHotKeys=function(){return true;};b.getVersion=function(){return "3.0.00";};});jsx3.Dialog=jsx3.gui.Dialog;
