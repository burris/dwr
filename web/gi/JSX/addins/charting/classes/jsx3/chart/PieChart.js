/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.RadialChart","jsx3.chart.PieSeries");jsx3.Class.defineClass("jsx3.chart.PieChart",jsx3.chart.RadialChart,null,function(n,g){g.init=function(r,c,f,q,i){this.jsxsuper(r,c,f,q,i);this.innerRadius=0;this.seriesPadding=0.1;this.totalAngle=360;this.startAngle=0;this.categoryField=null;this.colors=null;this.colorFunction="jsx3.chart.PieChart.defaultColoring";this.seriesStroke=null;};g.getInnerRadius=function(){return this.innerRadius!=null?this.innerRadius:0;};g.setInnerRadius=function(c){this.innerRadius=c==null?null:Math.max(0,Math.min(1,c));};g.getSeriesPadding=function(){return this.seriesPadding!=null?this.seriesPadding:0.1;};g.setSeriesPadding=function(c){this.seriesPadding=c;};g.getTotalAngle=function(){return this.totalAngle!=null?this.totalAngle:360;};g.setTotalAngle=function(h){this.totalAngle=h==null?null:Math.max(0,Math.min(360,h));};g.getStartAngle=function(){return this.startAngle!=null?this.startAngle:0;};g.setStartAngle=function(m){this.startAngle=m;};g.getCategoryField=function(){return this.categoryField;};g.setCategoryField=function(c){this.categoryField=c;};g.getColors=function(){return this.colors;};g.setColors=function(j){this.colors=j;};g.getColorFunction=function(){return this.vd("colorFunction");};g.setColorFunction=function(r){this.Dd("colorFunction",r);};g.getSeriesStroke=function(){return this.seriesStroke;};g.setSeriesStroke=function(h){this.seriesStroke=h;};g.eo=function(e,o){var
qc=this.getColors();if(qc!=null&&qc.length>0)return jsx3.vector.Fill.valueOf(qc[o%qc.length]);var
Jc=this.getColorFunction();if(Jc!=null)return Jc.call(null,e,o);return new
jsx3.vector.Fill();};g.updateView=function(){this.jsxsuper();var
_=this.wg();var
bc=this.Cm();var
Bc=this.bi();if(bc.length<1)return;if(Bc==null||Bc.length<1)return;var
Fb=bc[0].getWidth();var
vb=bc[0].getHeight();var
J=Math.round(Fb/2);var
xc=Math.round(vb/2);var
T=Math.floor(Math.min(Fb,vb)/2);var
Pb=this.Oh(bc,"getValue",true);var
K=T*(1-this.getInnerRadius())/(bc.length+(bc.length-1)*this.getSeriesPadding());var
Mc=T*this.getInnerRadius();for(var
v=0;v<bc.length;v++){var
db=bc[v];db.If();var
G=db.getStartAngle();if(G==null)G=this.getStartAngle();var
Eb=db.getTotalAngle();if(Eb==null)Eb=this.getTotalAngle();var
nc=Mc+K;for(var
Jb=0;Jb<Bc.length;Jb++){var
Gc=Bc[Jb];var
sb=db.getValue(Gc);if(sb==null||sb<=0){db.Nd();continue;}var
Y=Eb*sb/Pb[v];db.Ff(Gc,J,xc,G,G+Y,Math.round(Mc),Math.round(nc),100*sb/Pb[v]);G=G+Y;}db.updateView();_.appendChild(db.tf());Mc=Mc+K*(1+this.getSeriesPadding());}};g.ad=function(){return true;};g.zm=function(a){return a instanceof jsx3.chart.PieSeries;};g.getLegendEntryType=function(){jsx3.require("jsx3.chart.Legend");return 2;};g.toString=function(){return "[PieChart '"+this.getName()+"']";};n.defaultColoring=function(s,j){return jsx3.chart.Chart.DEFAULT_FILLS[j%jsx3.chart.Chart.DEFAULT_FILLS.length];};n.getVersion=function(){return jsx3.chart.sj;};});
