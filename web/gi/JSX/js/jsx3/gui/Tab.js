/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.Tab",jsx3.gui.Block,null,function(p,d){var
Kc=jsx3.gui.Event;var
Sb=jsx3.gui.Interactive;p.DEFAULTBEVELIMAGE=jsx3.resolveURI("jsx:///images/tab/bevel.gif");p.DEFAULTACTIVECOLOR="#e8e8f5";p.DEFAULTINACTIVECOLOR="#d8d8e5";p.DEFAULTHIGHLIGHT="#f6f6ff";p.DEFAULTSHADOW="#a6a6af";p.ACTIVEBEVEL=jsx3.resolveURI("jsx:///images/tab/on.gif");p.INACTIVEBEVEL=jsx3.resolveURI("jsx:///images/tab/off.gif");jsx3.html.loadImages(p.DEFAULTBEVELIMAGE,p.ACTIVEBEVEL,p.INACTIVEBEVEL);p.CHILDBGCOLOR="#e8e8f5";p.STATEDISABLED=0;p.STATEENABLED=1;d.init=function(c,q,a,g,f){this.jsxsuper(c,null,null,a,null,q);if(g!=null)this.setActiveColor(g);if(f!=null)this.setInactiveColor(f);var
yc=new
jsx3.gui.Block(c+"_content",null,null,"100%","100%");yc.setOverflow(1);yc.setRelativePosition(0);yc.setBackgroundColor(g==null?p.CHILDBGCOLOR:g);this.setChild(yc,1,null,"JSXFRAG");};d.onSetParent=function(k){return jsx3.gui.TabbedPane&&k instanceof jsx3.gui.TabbedPane;};d.getBevel=function(){return this.jsxbevel;};d.setBevel=function(b){this.jsxbevel=b;return this;};d.getMaskProperties=function(){return jsx3.gui.Block.MASK_EAST_ONLY;};d.Wh=function(n,r){r.style.backgroundImage="url("+p.ACTIVEBEVEL+")";if(jsx3.EventHelp.isDragging())this.Pw(n,false);};d.gn=function(h,e){e.style.backgroundImage="url("+p.INACTIVEBEVEL+")";};d.Th=function(e,h){h.focus();if(e.leftButton())this.Pw(e);};d.doClickTab=function(k,c){this.Pw(this.isOldEventProtocol(),c);};d.doShow=function(){this.Pw(false);};d.Pw=function(m,f){this.getParent().Kf(m,this);};d.getActiveColor=function(){return this.jsxactivecolor;};d.setActiveColor=function(l){this.jsxactivecolor=l;return this;};d.getInactiveColor=function(){return this.jsxinactivecolor;};d.setInactiveColor=function(f){this.jsxinactivecolor=f;return this;};d.getEnabled=function(){return this.jsxenabled==null?1:this.jsxenabled;};d.setEnabled=function(j){this.jsxenabled=j;return this;};d.Rn=function(c,j){if(this.jsxsupermix(c,j))return;var
_b=c.keyCode();var
S=this.getChildIndex();var
Zb=this.getParent();if(_b>=37&&_b<=40){if(c.leftArrow()||c.upArrow()){var
Q=S>0?S-1:Zb.getChildren().length-1;}else if(c.rightArrow()||c.downArrow())var
Q=S<Zb.getChildren().length-1?S+1:0;Zb.Kf(c,Q,null,true);c.cancelAll();}else if(_b==9&&!c.shiftKey()){this.getContentChild().focus();c.cancelAll();}else if(_b==9)this.getParent().focus();};p.Tk={};p.Tk["click"]=true;p.Tk["keydown"]=true;p.Tk["mouseover"]=true;p.Tk["mouseout"]=true;d.Ln=function(l){return this.Jm(0)||this.li(0,this.getParent()?this.getParent().vf(this):{});};d.Vd=function(b,r,m){this.Qh(b,r,m,3);};d.zj=function(e){if(e==null||isNaN(e.parentwidth)||isNaN(e.parentheight)){e=this.getParent().Ln(this);}else if(e==null)e={};var
xc=this.getPadding();if(this.getWidth()!=null&&!isNaN(parseInt(this.getWidth())))e.width=this.getWidth();e.height="100%";e.tagname="span";e.boxtype="relativebox";e.padding=xc!=null&&xc!=""?xc:"3 4 1 4";e.border="0px pseudo;2px pseudo;0px pseudo;1px pseudo";var
hb=new
jsx3.gui.Painted.Box(e);var
Gc={};Gc.parentwidth=hb.Si();Gc.parentheight=hb.Zh();Gc.height="100%";if(!(this.getWidth()==null||isNaN(this.getWidth()))){Gc.width="100%";Gc.tagname="div";Gc.boxtype="inline";}else{Gc.tagname="span";Gc.boxtype="relativebox";}var
I=new
jsx3.gui.Painted.Box(Gc);hb.Od(I);return hb;};d.paint=function(){if(!(this.getParent() instanceof jsx3.gui.TabbedPane)){jsx3.util.Logger.doLog("t21","The jsx3.gui.Tab instance with the id, '"+this.getId()+"', could not be painted on-screen, because it does not belong to a jsx3.gui.TabbedPane parent.");return "";}this.applyDynamicProperties();var
Gc=this.getEnabled()==1?this.qk(p.Tk,0):"";var
F=this.renderAttributes(null,true);var
R=this.vi(true);R.setAttributes('id="'+this.getId()+'"'+this.so()+this.vo()+this.fo()+Gc+' class="jsx30tab" '+F);R.setStyles(this.En()+this.Nh()+this.Dg()+this.Eo()+this.Ak()+this.xp()+this.Wm()+this.Ho()+this.ji());var
pb=R.tp(0);pb.setAttributes(' class="jsx30tab_text" unselectable="on" ');pb.setStyles(this.Ho());return R.paint().join(pb.paint().join(this.im()));};d.setWidth=function(o,a){this.jsxsuper(o);if(a)this.repaint();};d.setText=function(s,m){this.jsxsuper(s,m);if(m&&this.getParent())this.getParent().Ld();};d.En=function(){return "background-image:url("+p.INACTIVEBEVEL+");background-repeat:repeat-x;background-position:top left;";};d.Nh=function(){return this.getEnabled()==1?"cursor:pointer;":"cursor:not-allowed;";};d.vo=function(){return this.jsxsuper(this.getIndex()||Number(0));};d.uj=function(){return this.getActiveColor()?this.getActiveColor():p.DEFAULTACTIVECOLOR;};d.Uf=function(){return this.getInactiveColor()?this.getInactiveColor():p.DEFAULTINACTIVECOLOR;};d.Dg=function(){var
ob=this.getChildIndex()!=this.getParent().getSelectedIndex()?this.Uf():this.uj();return ob?"background-color:"+ob+";":"";};p.getVersion=function(){return "3.0.00";};d.getContentChild=function(){return this.getChild(0);};d.Zo=function(e){var
Bc=this.getContentChild();if(Bc)Bc.Zo(e);this.jsxsuper(e);};});jsx3.Tab=jsx3.gui.Tab;
