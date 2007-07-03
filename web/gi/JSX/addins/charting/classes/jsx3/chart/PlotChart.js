/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.CartesianChart","jsx3.chart.PointSeries");jsx3.Class.defineClass("jsx3.chart.PlotChart",jsx3.chart.CartesianChart,null,function(p,d){p.MAG_RADIUS="radius";p.MAG_DIAMETER="diameter";p.MAG_AREA="area";p.DEFAULT_MAX_POINT_RADIUS=30;p.s4={radius:1,diameter:1,area:1};d.init=function(k,o,r,e,s){this.jsxsuper(k,o,r,e,s);this.maxPointRadius=p.DEFAULT_MAX_POINT_RADIUS;this.magnitudeMethod="radius";};d.getMaxPointRadius=function(){return this.maxPointRadius!=null?this.maxPointRadius:Number.POSITIVE_INFINITY;};d.setMaxPointRadius=function(k){this.maxPointRadius=k;};d.getMagnitudeMethod=function(){return this.magnitudeMethod;};d.setMagnitudeMethod=function(c){if(p.s4[c]){this.magnitudeMethod=c;}else throw new
jsx3.IllegalArgumentException("magnitudeMethod",c);};d.getXRange=function(f){return this.getRangeForField(f,"getXValue");};d.getYRange=function(q){return this.getRangeForField(q,"getYValue");};d.updateView=function(){this.jsxsuper();this.ug();};d.ug=function(){var
C=this.wg();var
Bc=this.Cm();var
xb=this.bi();var
Kc=this.getPrimaryXAxis();var
T=this.getPrimaryYAxis();if(Kc==null||T==null||Bc.length==0||xb==null)return;if(!jsx3.chart.isValueAxis(Kc)){jsx3.chart.LOG.error("bad x axis type: "+Kc.getClass());return;}if(!jsx3.chart.isValueAxis(T)){jsx3.chart.LOG.error("bad y axis type: "+T.getClass());return;}for(var
Fb=0;Fb<Bc.length;Fb++){var
K=Bc[Fb];K.ui();for(var
ac=0;ac<xb.length;ac++){var
y=xb[ac];var
qc=K.getXValue(y);var
Kb=K.getYValue(y);if(qc==null||Kb==null)continue;qc=Kc.getCoordinateForNoClip(qc);Kb=T.getCoordinateForNoClip(Kb);if(K instanceof jsx3.chart.PointSeries){K.Co(y,ac,qc,Kb);}else{var
Hc=K.getMagnitudeValue(y);if(Hc!=null)K.Co(y,ac,qc,Kb,Hc);}}K.updateView();C.appendChild(K.tf());}};d.zm=function(q){return q instanceof jsx3.chart.PlotSeries;};d.toString=function(){return "[PlotChart '"+this.getName()+"']";};p.getVersion=function(){return jsx3.chart.sj;};});
