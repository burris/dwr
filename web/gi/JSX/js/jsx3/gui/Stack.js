/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Stack",jsx3.gui.Block,null,function(g,r){var
Jb=jsx3.gui;var
ub=Jb.Event;var
Y=Jb.Block;g.ORIENTATIONV=0;g.ORIENTATIONH=1;g.ACTIVECOLOR="#aaaafe";g.INACTIVECOLOR="#aaaacb";g.CHILDBGCOLOR="#ffffff";g.BORDER="solid 1px #ffffff;solid 1px #9898a5;solid 1px #9898a5;solid 1px #ffffff";g.CAPTION_BORDER="solid 1px #c8c8d5;solid 1px #9898a5;solid 1px #9898a5;solid 1px #c8c8d5";g.BACKGROUND=jsx3.html.getCSSFade(false);g.BACKGROUNDH=jsx3.html.getCSSFade(true);r.init=function(j,f){this.jsxsuper(j,null,null,null,null,f);var
eb=new
Y(j+"_content",0,0,"100%","100%");eb.setOverflow(1);eb.setBorder(g.BORDER);eb.setBackgroundColor(g.CHILDBGCOLOR);this.setChild(eb,1,null,"JSXFRAG");};r.onSetParent=function(e){return Jb.StackGroup&&e instanceof Jb.StackGroup;};r.doShowStack=function(){this.iz(this.isOldEventProtocol());};r.doShow=function(){this.iz(false);};r.iz=function(k,b){var
Db=this.getParent();if(this==Db.getChild(Db.getSelectedIndex()))return;Db.setSelectedIndex(this.getChildIndex());if(k instanceof ub){var
D=jsx3.html.getJSXParent(k.srcElement());if(D!=null&&D!=this)return;}var
hc=Db.vi();Db.Ch({left:0,top:0,parentwidth:hc.Ll(),parentheight:hc.Fg()},true);if(k)this.doEvent("jsxexecute",{objEVENT:k instanceof ub?k:null});this.doEvent("jsxshow");if(b)b.focus();};r.Wh=function(m,s){s.style.backgroundColor=this.getActiveColor();return;if(jsx3.EventHelp.isDragging())this.iz(m);var
lc=jsx3.html.getCSSOpacity(0.75);Jb.Painted.Be(s,lc);};r.gn=function(q,o){o.style.backgroundColor=this.getInactiveColor();return;var
ic=jsx3.html.getCSSOpacity(1);Jb.Painted.Be(o,ic);};r.getContentChild=function(){var
Kc=this.getChildren().length;for(var
Wb=0;Wb<Kc;Wb++){var
E=this.getChild(Wb);if(!(Jb.Menu&&E instanceof Jb.Menu)&&!(Jb.ToolbarButton&&E instanceof Jb.ToolbarButton))return E;}return null;};r.Rn=function(l,a){if(this.jsxsupermix(l,a))return;if(l.enterKey()||l.spaceKey()){this.iz(l);l.cancelAll();}};g.Tk={};g.Tk["click"]="iz";g.Tk["keypress"]=true;g.Tk["mouseover"]=true;g.Tk["mouseout"]=true;r.Ln=function(n){var
Cb=this.Jm(0);if(Cb)return Cb;var
tc={};if(this.getParent()){var
Lc=this.getParent().Ln(this);var
ec=this.getParent().paintBarSize();var
qb=0,bb=0,z=Lc.parentwidth,Tb=Lc.parentheight;if(this.getOrientation()==0){bb=ec;Tb=Tb-ec;}else{qb=ec;z=z-ec;}tc={boxtype:"box",left:qb,top:bb,width:z,height:Tb,parentwidth:z,parentheight:Tb};}return this.li(0,tc);};r.Vd=function(h,e,j){var
Kc=this.vi(true,h);if(e){var
V=Kc.recalculate(h,e,j);if(!V.w&&!V.h)return;var
ec=this.getParent().paintBarSize();var
Tb=Kc.Si();var
_=Kc.Zh();var
hc={};if(this.getOrientation()==0){hc.height=ec;hc.parentwidth=h.parentwidth;}else{hc.width=ec;hc.parentheight=h.parentheight;}var
G=Kc.tp(0);G.recalculate(hc,e?e.childNodes[0]:null,j);var
t=this.getContentChild();if(t!=null)if(this.isFront()){var
Mc=this.getOrientation()==0?{boxtype:"box",left:0,top:ec,width:Tb,height:_-ec,parentwidth:Tb,parentheight:_-ec}:{boxtype:"box",left:ec,top:0,width:Tb-ec,height:_,parentwidth:Tb-ec,parentheight:_};j.add(t,Mc,t.getRendered(e),true);t.setVisibility("",true);}else t.setVisibility("hidden",true);}};r.zj=function(m){if(this.getParent()&&(m==null||isNaN(m.parentwidth)||isNaN(m.parentheight))){m=this.getParent().Ln(this);}else if(m==null)m={};m.width="100%";m.height="100%";m.tagname="div";m.boxtype="box";var
Nc=new
Jb.Painted.Box(m);var
mb=this.getParent().paintBarSize();var
vb={};vb.parentwidth=Nc.Si();vb.parentheight=Nc.Zh();if(this.getOrientation()==0){vb.width="100%";vb.height=mb;}else{vb.width=mb;vb.height="100%";}vb.left=0;vb.top=0;vb.tagname="div";vb.boxtype="box";vb.border=g.CAPTION_BORDER;vb.padding="0 0 0 4";var
wc=new
Jb.Painted.Box(vb);Nc.Od(wc);vb={};vb.tagname="div";vb.boxtype="box";vb.left=0;vb.top=0;vb.padding=this.getPadding();var
Ub=new
Jb.Painted.Box(vb);wc.Od(Ub);return Nc;};r.paint=function(){if(!(this.getParent() instanceof Jb.StackGroup))return "";this.applyDynamicProperties();var
Nb=this.vi(true);Nb.setAttributes('id="'+this.getId()+'"'+this.so()+' class="'+this.Wg()+'"');Nb.setStyles("overflow:hidden;");var
zc=this.qk(g.Tk,1);var
pc=this.renderAttributes(null,true);var
F=Nb.tp(0);F.setAttributes(this.vo()+this.fo()+zc+pc+' class="jsx30stack_handle"');F.setStyles(this.Dg()+this.mg()+this.Eo()+this.Ak()+this.xp()+this.Wm()+this.Ho()+this.ji());var
Ob=this.getChildren();var
J=[],tc=[];for(var
Q=0;Q<Ob.length;Q++){var
ac=Ob[Q].paint();if(Jb.Menu&&Ob[Q] instanceof Jb.Menu||Jb.ToolbarButton&&Ob[Q] instanceof Jb.ToolbarButton){tc.push(Ob[Q]);}else if(J.length==0)J.push(Ob[Q]);}var
gc=this.paintChildren(tc);var
mb=this.paintChildren(J);var
lc=F.tp(0);var
Wb=this.getOrientation()==0?"jsx30stack_textv":"jsx30stack_texth";lc.setAttributes(' class="'+Wb+'" unselectable="on" ');var
jb=lc.paint().join(this.im());return Nb.paint().join(F.paint().join(jb+gc)+mb);};r.Ho=function(){var
gb;if(this.getTextAlign()){gb=this.getTextAlign();}else if(this.getParent()&&this.getOrientation()==0){gb="right";}else gb="left";return "text-align:"+gb+";";};r.setText=function(b,k){this.jsxsuper(b,false);var
Nb;if(k&&(Nb=this.getRendered())!=null)Nb.firstChild.firstChild.innerHTML=b;return this;};r.getPadding=function(){var
nb=this.jsxsuper();return nb!=null&&nb!=""?nb:"5 5 5 5";};r.getFontWeight=function(){return this.jsxsuper()||"bold";};r.mg=function(){return (this.getBackground()?this.getBackground():this.getOrientation()==1?g.BACKGROUNDH:g.BACKGROUND)+";";};r.vo=function(){return this.jsxsuper(this.getIndex()||Number(0));};r.getActiveColor=function(){return this.jsxactivecolor==null?g.ACTIVECOLOR:this.jsxactivecolor;};r.setActiveColor=function(d){this.jsxactivecolor=d;return this;};r.getInactiveColor=function(){return this.jsxinactivecolor==null?g.INACTIVECOLOR:this.jsxinactivecolor;};r.setInactiveColor=function(n){this.jsxinactivecolor=n;return this;};r.getOrientation=function(){return this.getParent()!=null?this.getParent().getOrientation():0;};r.focus=function(){this.doShow();this.jsxsuper();};r.isFront=function(){var
pb=this.getChildIndex();return pb>=0&&this.getParent().getSelectedIndex()==pb;};r.getMaskProperties=function(){return Y.MASK_NO_EDIT;};g.getVersion=function(){return "3.0.00";};r.Zo=function(i){var
rc=this.getContentChild();if(rc)rc.Zo(i);this.jsxsuper(i);};});jsx3.gui.Stack.prototype.getBackgroundColor=jsx3.gui.Stack.prototype.getInactiveColor;jsx3.gui.Stack.prototype.setBackgroundColor=jsx3.gui.Stack.prototype.setInactiveColor;jsx3.Stack=jsx3.gui.Stack;
