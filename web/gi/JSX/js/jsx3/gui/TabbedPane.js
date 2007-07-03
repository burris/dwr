/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block","jsx3.gui.Tab");jsx3.Class.defineClass("jsx3.gui.TabbedPane",jsx3.gui.Block,null,function(s,k){var
V=jsx3.gui.Tab;var
pc=jsx3.gui.Event;var
Bc=jsx3.gui.Block;var
Mc=jsx3.gui.Interactive;s.AUTO_SCROLL_INTERVAL=50;s.LSCROLLER=jsx3.html.getCSSPNG(jsx3.resolveURI("jsx:///images/tab/l.png"));s.RSCROLLER=jsx3.html.getCSSPNG(jsx3.resolveURI("jsx:///images/tab/r.png"));s.DEFAULTTABHEIGHT=20;k.init=function(o){this.jsxsuper(o);};k.paintChild=function(c,f){var
Nb=this.getRendered();if(Nb!=null){if(this.getShowTabs())jsx3.html.insertAdjacentHTML(Nb.childNodes[0].childNodes[0],"beforeEnd",c.paint());var
db=c.getContentChild();var
Dc=this.getChildren().length==1;db.setDisplay(Dc?"":"none");jsx3.html.insertAdjacentHTML(Nb,"beforeEnd",c.paintChildren([db]));if(Dc)this.Kf(null,c);}this.Ld();};k.onSetChild=function(c){if(!(c instanceof V))return false;var
hc=c.getContentChild();if(hc)hc.setVisibility("");if(this.getChildren().length==0)this.jsxselectedindex=-1;return true;};k.onRemoveChild=function(j,p){this.jsxsuper(j,p);if(j instanceof Array){var
u=j[this.getSelectedIndex()];if(u)u.doEvent("jsxhide");this.doEvent("jsxchange");this.setSelectedIndex(-1);this.fi();this.repaint();}else{var
Ic=this.getSelectedIndex();var
vc=Math.min(this.getChildren().length-1,Ic);if(Ic==p)j.doEvent("jsxhide");this.Kf(false,vc,true);this.Ld();}};k.getSelectedIndex=function(){return this.jsxselectedindex==null?this.getChildren().length>0?0:-1:this.jsxselectedindex;};k.setSelectedIndex=function(m,r){if(r){this.Kf(false,m);}else this.jsxselectedindex=m instanceof V?m.getChildIndex():m;return this;};k.ZY=function(e,h){this.doDrop(e,h,jsx3.EventHelp.ONDROP);};k.Ln=function(){var
vc=this.Jm(0);if(vc)return vc;var
Ib={};if(this.getParent()){var
Ic=this.getParent().Ln(this);var
U=Ic.width?Ic.width:Ic.parentwidth;var
Jb=this.getShowTabs()?this.paintTabSize()+1:0;Ib={parentwidth:U,parentheight:Jb};}return this.li(0,Ib);};k.vf=function(){if(this.getParent()){var
H=this.getParent().Ln(this);var
lb=H.width!=null&&!isNaN(H.width)?H.width:H.parentwidth;var
Cb=this.getShowTabs()?this.paintTabSize():0;var
Ab=(H.height!=null&&!isNaN(H.height)?H.height:H.parentheight)-Cb;var
Zb={left:0,top:Cb,width:lb,height:Ab,parentwidth:lb,parentheight:Ab,boxtype:"box",tagname:"div"};if(this.getShowTabs())Zb.border="solid 1px #f6f6ff;solid 1px #a6a6af;solid 1px #a6a6af;solid 1px #f6f6ff";return Zb;}return {};};k.Vd=function(f,c,l){var
L=this.vi(true,f);if(c){L.recalculate(f,c,l);var
Yb=L.tp(0);Yb.recalculate({parentwidth:L.Si(),height:this.paintTabSize()+1},c!=null?c.childNodes[0]:null,l);var
P=Yb.tp(0);P.recalculate({parentwidth:L.Si(),height:this.paintTabSize()+1},c!=null?c.childNodes[0].childNodes[0]:null,l);var
Bb=Yb.tp(2);Bb.recalculate({left:Yb.Si()-22},c!=null?c.childNodes[0].childNodes[2]:null,l);var
jb=this.getChildren();var
wb=this.Ln();for(var
R=0;R<jb.length;R++){var
v=jb[R];l.add(v,this.Ln(),c!=null,true);var
Rb=v.getContentChild();if(Rb!=null){var
tb=this.getSelectedIndex()==R;Rb.setDisplay(tb?"":"none",true);if(tb)l.add(Rb,this.vf(),Rb.getRendered(c),true);}}this.Ld();}};k.zj=function(b){if(this.getParent()&&(b==null||!isNaN(b.parentwidth)&&!isNaN(b.parentheight)||!isNaN(b.width)&&!isNaN(b.height))){b=this.getParent().Ln(this);}else if(b==null)b={};if(b.left==null)b.left=0;if(b.top==null)b.top=0;if(b.width==null)b.width="100%";if(b.height==null)b.height="100%";if(b.tagname==null)b.tagname="div";if(b.boxtype==null)b.boxtype="box";var
y=this.getBorder();if(y!=null&&y!="")b.border=y;var
Yb=new
jsx3.gui.Painted.Box(b);var
t={};t.parentwidth=b.parentwidth;t.width="100%";t.height=this.paintTabSize()+1;t.left=0;t.top=0;t.tagname="div";t.boxtype="box";var
Lc=new
jsx3.gui.Painted.Box(t);Yb.Od(Lc);t={};t.parentwidth=b.parentwidth;t.width="100%";t.height=this.paintTabSize()+1;t.left=0;t.top=0;t.tagname="div";t.boxtype="box";var
H=new
jsx3.gui.Painted.Box(t);H.setStyles("white-space:nowrap;");Lc.Od(H);t={};t.width=14;t.height=14;t.left=2;t.top=2;t.tagname="div";t.boxtype="box";var
pb=new
jsx3.gui.Painted.Box(t);Lc.Od(pb);t={};t.width=14;t.height=14;t.left=Lc.Si()-16;t.top=2;t.tagname="div";t.boxtype="box";var
zc=new
jsx3.gui.Painted.Box(t);Lc.Od(zc);return Yb;};k.paint=function(){this.applyDynamicProperties();var
ac=this.getId();var
ob=this.getShowTabs();var
Ub=this.getSelectedIndex();if(Ub<0||Ub>=this.getChildren().length){Ub=0;this.setSelectedIndex(Ub);}var
bc={};if(this.hasEvent("jsxdrop")||this.hasEvent("jsxctrldrop"))bc["mouseup"]=true;var
Sb=this.qk(bc,0);var
mb=this.renderAttributes(null,true);var
D=this.vi(true);D.setAttributes('id="'+ac+'" class="jsx30tabbedpane"'+this.so()+this.vo()+this.fo()+Sb+mb);D.setStyles(this.vl()+this.Dg()+this.mg()+this.Af()+this.Dh()+this.ji());var
uc=D.tp(0);if(ob){var
M=this.getChild(Ub);M=M==null?this.getChild(0):M;if(M!=null)if(!M.getEnabled()){var
G=this.getChildren().length-1;for(var
zb=0;zb<=G;zb++)if(this.getChild(zb).getEnabled()){this.setSelectedIndex(zb);break;}}var
w=this.paintChildren();uc.setStyles(this.Ho());}else{var
w="&#160;";uc.setStyles("visibility:hidden;");}uc.setAttributes('class="jsx30tabbedpane_controlbox"');var
tb=this.getChildren();var
Pb=[];for(var
zb=0;zb<tb.length;zb++){var
ib=tb[zb].getContentChild();if(ib!=null){ib.setDisplay(this.getSelectedIndex()==zb?"":"none");ib.ak(this.vf());Pb.push(ib);}}jsx3.sleep(function(){this.Ld();},null,this);var
_=uc.tp(0);var
Ob=uc.tp(1);Ob.setStyles("display:none;"+s.LSCROLLER);Ob.setAttributes('class="jsx30tabbedpane_autoscroller_l" jsxscrolltype="left" '+this.cn("mouseover","Zt")+this.cn("mouseout","F0"));var
Cc=uc.tp(2);Cc.setStyles("display:none;"+s.RSCROLLER);Cc.setAttributes('class="jsx30tabbedpane_autoscroller_r" jsxscrolltype="right" '+this.cn("mouseover","Zt")+this.cn("mouseout","F0"));return D.paint().join(uc.paint().join(_.paint().join(w)+Ob.paint().join("&#160;")+Cc.paint().join("&#160;"))+this.paintChildren(Pb));};k.Ld=function(){var
cb=this.Q0();var
Xb=this.Ln().parentwidth;var
Y=this.H9();if(Y)if(Xb<cb){Y.nextSibling.style.display=parseInt(Y.style.left)<0?"":"none";Y.nextSibling.nextSibling.style.display="";}else{Y.nextSibling.style.display="none";Y.nextSibling.nextSibling.style.display="none";Y.style.left="0px";}};k.Q0=function(){var
O=this.H9();if(O){var
t=O.childNodes;var
x=0;for(var
_=0;_<t.length;_++)x=x+parseInt(t[_].offsetWidth);return x;}};k.Zt=function(f,g){var
ob=this;this._jsxJK={direction:g.getAttribute("jsxscrolltype"),totalwidth:this.Q0()-this.Ln().parentwidth};this._jsxJK.interval=window.setInterval(function(){ob.Fy();},s.AUTO_SCROLL_INTERVAL);};k.H9=function(){var
U=this.getRendered();return U?U.childNodes[0].childNodes[0]:null;};k.Fy=function(){var
I=this.H9();var
Kc=parseInt(I.style.left);if(this._jsxJK.direction=="left"){if(Kc-5<0){I.style.left=Kc+5+"px";I.nextSibling.nextSibling.style.display="";}else{I.style.left="0px";I.nextSibling.style.display="none";this.F0();}}else if(Math.abs(Kc)+5<=this._jsxJK.totalwidth){I.style.left=Kc-5+"px";I.nextSibling.style.display="";}else{I.style.left="-"+this._jsxJK.totalwidth+"px";I.nextSibling.nextSibling.style.display="none";this.F0();}};k.F0=function(b,q){if(this._jsxJK){window.clearInterval(this._jsxJK.interval);delete this._jsxJK;}};k.vo=function(){return this.jsxsuper(this.getIndex()||Number(0));};k.paintTabSize=function(){return this.getTabHeight()!=null&&!isNaN(this.getTabHeight())?this.getTabHeight():s.DEFAULTTABHEIGHT;};k.getTabHeight=function(){return this.jsxtabheight;};k.setTabHeight=function(c){this.jsxtabheight=c;this.qo(true);return this;};k.getShowTabs=function(){return this.jsxshowtabs==null||this.jsxshowtabs===""?1:this.jsxshowtabs;};k.setShowTabs=function(c){this.jsxshowtabs=c;this.qo(true);return this;};k.Kf=function(f,r,a,g){if(!(r instanceof V))r=this.getChild(r);if(r){var
x=this.getShowTabs();var
U=r.getChildIndex();var
Lb=this.getSelectedIndex();if(a||Lb!=U){this.setSelectedIndex(U);var
ub=this.getChildren().length;for(var
W=0;W<ub;W++){var
Nb=this.getChild(W);var
B=Nb.getContentChild();if(W==U){if(B)B.setDisplay("",true);if(x)Nb.setBackgroundColor(Nb.uj(),true);B.Ch(this.vf(),true);}else{if(B)B.setDisplay("none",true);if(x)Nb.setBackgroundColor(Nb.Uf(),true);}}}if(f)r.doEvent("jsxexecute",{objEVENT:f instanceof pc?f:null});if(!a){var
jc=this.getChild(Lb);if(jc)jc.doEvent("jsxhide");}if(g)r.focus();r.doEvent("jsxshow");this.doEvent("jsxchange");}};s.getVersion=function(){return "3.0.00";};});jsx3.TabbedPane=jsx3.gui.TabbedPane;
