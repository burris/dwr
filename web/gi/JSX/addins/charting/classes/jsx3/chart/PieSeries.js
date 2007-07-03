/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Series");jsx3.Class.defineClass("jsx3.chart.PieSeries",jsx3.chart.Series,null,function(i,h){var
G=jsx3.vector;i.LABEL_PLACEMENTS={top:1,right:1,bottom:1,left:1};h.init=function(s,m){this.jsxsuper(s,m);this.field=null;this.totalAngle=null;this.startAngle=null;this.colors=null;this.colorFunction=null;this.stroke=null;this.labelPlacement="bottom";this.labelOffset=10;this.setTooltipFunction("jsx3.chart.PieSeries.tooltip");};h.getTotalAngle=function(){return this.totalAngle;};h.setTotalAngle=function(q){this.totalAngle=q==null?null:Math.max(0,Math.min(360,q));};h.getStartAngle=function(){return this.startAngle;};h.setStartAngle=function(l){this.startAngle=l==null?null:jsx3.util.numMod(l,360);};h.getField=function(){return this.field;};h.setField=function(c){this.field=c;};h.getValue=function(p){if(this.field)return jsx3.chart.asNumber(p.getAttribute(this.field));return null;};h.getColors=function(){return this.colors;};h.setColors=function(g){this.colors=g;};h.getLabelPlacement=function(){return this.labelPlacement!=null?this.labelPlacement:"bottom";};h.setLabelPlacement=function(o){if(i.LABEL_PLACEMENTS[o]){this.labelPlacement=o;}else throw new
jsx3.IllegalArgumentException("labelPlacement",o);};h.getLabelOffset=function(){return this.labelOffset!=null?this.labelOffset:0;};h.setLabelOffset=function(m){this.labelOffset=Math.round(m);};h.eo=function(r,j){var
Y=this.getColors();if(Y!=null&&Y.length>0)return G.Fill.valueOf(Y[j%Y.length]);var
O=this.getColorFunction();if(O!=null)return O.call(null,r,j);var
Bb=this.getChart();if(Bb!=null)return Bb.eo(r,j);return new
G.Fill();};h.a2=function(d){if(this.stroke)return G.Stroke.valueOf(this.stroke);var
x=this.getChart();if(x!=null){var
sc=x.getSeriesStroke();if(sc)return G.Stroke.valueOf(sc);}return null;};h.Ff=function(j,k,g,o,s,r,p,l){var
pb=this.pk("We");if(pb==null){pb=[];this.tm("We",pb);}pb.push([j,k,g,o,s,r,p,l]);};h.Nd=function(){this.Ff(null);};h.If=function(){var
uc=this.pk("We");if(uc!=null)uc.splice(0,uc.length);};h.updateView=function(){this.jsxsuper();var
xb=this.tf();var
ob=xb.getWidth();var
U=xb.getHeight();var
R=this.pk("We");if(R==null)return;var
Y=this.getTooltipFunction();for(var
vb=0;vb<R.length;vb++){var
Db=R[vb][0];if(Db==null)continue;var
Q=R[vb][1];var
w=R[vb][2];var
ib=R[vb][3];var
J=R[vb][4];var
hb=R[vb][5];var
Hb=R[vb][6];var
_b=R[vb][7];var
Lb=new
G.Shape(null,0,0,ob,U);Lb.setId(this.getId()+"_s"+vb);xb.appendChild(Lb);Lb.setFill(this.eo(Db,vb));Lb.setStroke(this.a2(vb));this.th(Lb,vb,Db.getAttribute("jsxid"));var
u=G.degreesToRadians(J);var
dc=G.degreesToRadians(ib);var
rb=Math.round(Hb*Math.cos(u))+Q;var
Dc=Math.round(-1*Hb*Math.sin(u))+w;var
Fc=Math.round(Hb*Math.cos(dc))+Q;var
lb=Math.round(-1*Hb*Math.sin(dc))+w;var
x=rb==Fc&&Dc==lb&&J-ib>180;Lb.dl(rb,Dc);if(x||rb!=Fc||Dc!=lb)Lb.Aj(Q,w,Hb,Hb,rb,Dc,Fc,lb,false);if(hb>0){var
yb=Math.round(hb*Math.cos(u))+Q;var
Ic=Math.round(-1*hb*Math.sin(u))+w;var
vc=Math.round(hb*Math.cos(dc))+Q;var
_=Math.round(-1*hb*Math.sin(dc))+w;Lb.pj(vc,_);if(x||yb!=vc||Ic!=_)Lb.Aj(Q,w,hb,hb,vc,_,yb,Ic,true);}else if(!x)Lb.pj(Q,w);Lb.Bh();if(Y!=null)Lb.setToolTip(Y.call(null,this,Db,_b));}var
Ec=this.getLabel();if(Ec!=null&&Ec.getDisplay()!=jsx3.gui.Block.DISPLAYNONE){var
Nb=[0,0,ob,U];if(R.length>0)Nb=[R[0][1]-R[0][6],R[0][2]-R[0][6],R[0][1]+R[0][6],R[0][2]+R[0][6]];var
cb=Ec.getPreferredWidth();var
V=Ec.getPreferredHeight();var
Nc=0,Jc=0;if(this.labelPlacement=="top"){Nc=Math.round(ob/2-cb/2);Jc=Nb[1]-this.getLabelOffset()-V;}else if(this.labelPlacement=="right"){Nc=Nb[2]+this.getLabelOffset();Jc=Math.round(U/2-V/2);}else if(this.labelPlacement=="left"){Nc=Nb[0]-this.getLabelOffset()-cb;Jc=Math.round(U/2-V/2);}else{Nc=Math.round(ob/2-cb/2);Jc=Nb[3]+this.getLabelOffset();}Ec.setDimensions(Nc,Jc,cb,V);Ec.setText(this.getSeriesName());Ec.updateView();xb.appendChild(Ec.tf());}};i.tooltip=function(q,c,j){var
yc=q.getValue(c);return yc+", "+Math.round(j*10)/10+"%";};h.toString=function(){return "[PieSeries '"+this.getName()+"']";};i.getVersion=function(){return jsx3.chart.sj;};});
