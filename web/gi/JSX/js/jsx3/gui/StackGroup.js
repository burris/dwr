/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.gui.LayoutGrid","jsx3.gui.Stack");jsx3.Class.defineClass("jsx3.gui.StackGroup",jsx3.gui.LayoutGrid,null,function(c,p){var
jc=jsx3.gui.LayoutGrid;c.ORIENTATIONV=0;c.ORIENTATIONH=1;c.DEFAULTSTACKCOUNT=2;c.DEFAULTDIMENSIONS=["27","*"];c.DEFAULTBARSIZE=27;p.init=function(q){this.jsxsuper(q);};p.getBarSize=function(){return this.jsxbarsize;};p.setBarSize=function(s){this.jsxbarsize=s;return this;};p.Ln=function(g){var
sc=g.getChildIndex();var
t=this.Jm(sc);if(t)return t;var
Lb=this.getParent().Ln(this);var
cc=this.getOrientation()==0;var
Jb=Lb.width?Lb.width:Lb.parentwidth;var
D=Lb.height?Lb.height:Lb.parentheight;var
gb=this.paintBarSize();var
tc=cc?D:Jb;var
Kb=sc*gb+(this.getSelectedIndex()<sc?1:0)*(tc-(this.getChildren().length-1)*gb-gb);var
bb=0,Xb=Jb,Nb=D,xc=0;if(cc){xc=Kb;Nb=g.isFront()?D-gb*(this.getChildren().length-1):gb;}else{bb=Kb;Xb=g.isFront()?Jb-gb*(this.getChildren().length-1):gb;}return this.li(sc,{boxtype:"box",left:bb,top:xc,width:"100%",height:"100%",parentwidth:Xb,parentheight:Nb});};p.Vd=function(m,j,e){var
Ib=this.vi(true,m);if(j){Ib.recalculate(m,j,e);j.style.overflow="auto";}var
_b=0;var
fb=this.getChildren().length;for(var
Bb=0;Bb<fb;Bb++){var
F=this.getChild(Bb);var
Yb=this.Ln(F);e.add(F,Yb,j!=null,true);}};p.paint=function(){var
Ec=this.getChild(this.getSelectedIndex());if(Ec==null){Ec=this.getChild(0);this.setSelectedIndex(0);}if(Ec!=null){var
Mb=this.getChildren().length;var
Sb=[];var
kb=this.paintBarSize();var
wc=this.getSelectedIndex();for(var
Hb=0;Hb<Mb;Hb++)if(wc!=Hb){Sb[Hb]=kb;}else Sb[Hb]="*";if(this.getOrientation()==0)this.setRows(Sb.join(","));else this.setCols(Sb.join(","));}return this.jsxsuper();};p.paintBarSize=function(f){return this.getBarSize()?this.getBarSize():c.DEFAULTBARSIZE;};p.getSelectedIndex=function(){return this.jsxselectedindex==null?0:this.jsxselectedindex>this.getChildren().length-1?this.getChildren().length-1:this.jsxselectedindex;};p.setSelectedIndex=function(k){this.jsxselectedindex=k;};p.paintChild=function(d,k){var
gc=this.getRendered();if(gc!=null)jsx3.html.insertAdjacentHTML(gc,"beforeEnd",d.paint());if(!k)this.jH();};p.onSetChild=function(i){return i instanceof jsx3.gui.Stack;};p.onRemoveChild=function(r,e){this.jsxsuper(r,e);if(r instanceof Array){this.repaint();}else{var
rc=this.getChildren().length;var
A=e==this.jsxselectedindex;if(e<=this.jsxselectedindex&&(this.jsxselectedindex>0||rc==0))this.jsxselectedindex--;if(A&&this.jsxselectedindex>=0){this.jH();this.getChild(this.jsxselectedindex).doShow();}else this.jH();}};p.jH=function(){var
db=[];var
nc=this.paintBarSize();var
ic=this.getSelectedIndex();var
fb=this.getChildren().length;for(var
sc=0;sc<fb;sc++)db[sc]=ic!=sc?nc:"*";if(this.getOrientation()==0)this.setRows(db.join(","));else this.setCols(db.join(","));};p.getOrientation=function(){return this.jsxorientation==null?0:this.jsxorientation;};p.setOrientation=function(q){this.jsxorientation=q;return this;};c.getVersion=function(){return "3.0.00";};});jsx3.StackGroup=jsx3.gui.StackGroup;
