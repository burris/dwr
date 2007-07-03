/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.Block");jsx3.Class.defineClass("jsx3.gui.LayoutGrid",jsx3.gui.Block,null,function(g,j){g.ORIENTATIONCOL=0;g.ORIENTATIONROW=1;g.DEFAULTORIENTATION=0;g.DEFAULTREPEAT=3;g.DEFAULTDIMENSIONS=["33%","33%","34%"];g.ABSOLUTE=0;g.ADAPTIVE=1;j.init=function(c){this.jsxsuper(c);this.setCols("*");this.setRows("50%,50%");};j.onAfterAttach=function(){if(this.jsxsizearray&&!(this.jsxrows||this.jsxcols))this.setDimensionArray(this.jsxsizearray,false);this.jsxsuper();};j.onRemoveChild=function(a,n){this.jsxsuper(a,n);this.JT();};j.paintChild=function(i,l){if(!l){this.recalcBox();this.repaint();}};j.getOrientation=function(){return this.jsxorientation==null?g.DEFAULTORIENTATION:this.jsxorientation;};j.setOrientation=function(l){this.jsxorientation=l;return this;};j.getBestGuess=function(){return this.jsxbestguess;};j.setBestGuess=function(k){this.jsxbestguess=k;return this;};j.getRepeat=function(){return this.jsxrepeat;};j.setRepeat=function(o){this.jsxrepeat=o;return this;};j.getDimensionArray=function(){var
gc=this.getOrientation()==g.ORIENTATIONCOL?this.getRows():this.getCols();return gc!=null?gc.split(/\s*,\s*/g):[];};j.setDimensionArray=function(l,b){return this.getOrientation()==g.ORIENTATIONCOL?this.setRows(l.join(","),b):this.setCols(l.join(","),b);};j.getCols=function(){return this.jsxcols||"*";};j.setCols=function(p,q){this.jsxcols=p;if(q)this.JT();return this;};j.getRows=function(){return this.jsxrows||"*";};j.setRows=function(i,h){this.jsxrows=i;if(h)this.JT();return this;};j.JT=function(){var
_b=this.getRendered();if(_b!=null)this.Ch({},_b);};j.a5=function(h,o){var
Lc=h?"_jsxcachedrows":"_jsxcachedcols";var
Tb=this.vi(true);if(Tb[Lc] instanceof Array)return Tb[Lc];if(o==null||isNaN(o))o=h?Tb.Zh():Tb.Si();if(isNaN(o))return [];var
Dc=0;var
kc=0;var
Nb=h?this.getRows():this.getCols();if(!(Nb instanceof Array))Nb=Nb!=null?Nb.split(/\s*,\s*/g):[];var
gb=new
Array(Nb.length);for(var
Hc=0;Hc<Nb.length;Hc++){var
U=Nb[Hc];if(U=="*"){gb[Hc]="*";}else if(typeof U=="string"&&U.indexOf("%")>=0){var
db=parseInt(U);gb[Hc]=isNaN(db)?"*":db/100*o;}else{var
db=parseInt(U);gb[Hc]=isNaN(db)?"*":db;}if(gb[Hc]=="*")kc++;else Dc=Dc+gb[Hc];}if(kc>0){var
Qb=Math.max(0,o-Dc)/kc;for(var
Hc=0;Hc<gb.length;Hc++)if(gb[Hc]=="*")gb[Hc]=Qb;}Tb[Lc]=gb;return gb;};j.Ln=function(h){var
Z=h.getChildIndex();var
D=this.Jm(Z);if(D)return D;var
zc=this.getParent().Ln(this);var
cc=zc.width?zc.width:zc.parentwidth;var
nc=zc.height?zc.height:zc.parentheight;var
Rb=this.a5(true,nc);var
Tb=this.a5(false,cc);if(Rb.length==0||Tb.length==0)return {boxtype:"box",width:"100%",height:"100%"};var
Zb=Z%Tb.length;var
fc=Math.floor(Z/Tb.length);var
M=fc<Rb.length?Rb[fc]:0;var
_b=Tb[Zb];var
tc=0,z=0;for(var
u=0;u<fc&&u<Rb.length;u++)z=z+Rb[u];for(var
u=0;u<Zb&&u<Tb.length;u++)tc=tc+Tb[u];return this.li(Z,{boxtype:"box",left:tc,top:z,width:"100%",height:"100%",parentwidth:_b,parentheight:M});};j.Vd=function(m,k,e){if(this.getParent()&&(!isNaN(m.parentwidth)&&!isNaN(m.parentheight)||m.width==null&&m.height==null)){m=this.getParent().Ln(this);}else if(m==null)m={};var
V=this.vi(true,m);this.dR(V);if(k)V.recalculate(m,k,e);var
N=this.getChildren();var
Gc=this.a5(true);var
tc=this.a5(false);var
Zb=0,ib=0;var
wb=0,xb=N.length;for(var
qc=0;qc<Gc.length;qc++){ib=0;for(var
R=0;R<tc.length&&wb<xb;R++){var
_=N[wb++];e.add(_,{boxtype:"box",left:ib,top:Zb,width:"100%",height:"100%",parentwidth:tc[R],parentheight:Gc[qc]},k?k.childNodes[wb-1]:null,true);ib=ib+tc[R];}Zb=Zb+Gc[qc];}for(var
qc=wb;wb<xb;wb++){var
_=N[wb];e.add(_,{boxtype:"box",left:0,top:0,width:0,height:0,parentwidth:0,parentheight:0},k?k.childNodes[wb]:null,true);}};j.dR=function(d){delete d._jsxcachedrows;delete d._jsxcachedcols;};j.zj=function(l){if(this.getParent()&&(l==null||!isNaN(l.parentwidth)&&!isNaN(l.parentheight)||!isNaN(l.width)&&!isNaN(l.height))){l=this.getParent().Ln(this);}else if(l==null)l={};var
xc=this.getRelativePosition()!=0&&(!this.getRelativePosition()||this.getRelativePosition()==1);if(l.boxtype==null)l.boxtype=xc||l.left==null||l.top==null?"relativebox":"box";if(l.boxtype=="relativebox"){if(l.left==null)l.left=0;if(l.top==null)l.top=0;}if(l.width==null)l.width="100%";if(l.height==null)l.height="100%";l.tagname="div";l.container="true";var
J;if((J=this.getBorder())!=null&&J!="")l.border=J;return new
jsx3.gui.Painted.Box(l);};j.paint=function(){this.applyDynamicProperties();var
Wb=this.getChildren();var
Ic=this.a5(true);var
ib=this.a5(false);this.setOverflow(2);var
mb=0,w=0;var
cb=0,Y=Wb.length;for(var
t=0;t<Ic.length;t++){w=0;for(var
qb=0;qb<ib.length&&cb<Y;qb++){var
hb=Wb[cb++];hb.ak({left:w,top:mb,width:"100%",height:"100%",parentwidth:ib[qb],parentheight:Ic[t],boxtype:"box"});w=w+ib[qb];}mb=mb+Ic[t];}return this.jsxsuper();};g.getVersion=function(){return "3.0.00";};});jsx3.LayoutGrid=jsx3.gui.LayoutGrid;
