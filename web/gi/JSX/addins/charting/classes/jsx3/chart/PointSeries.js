/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Series","jsx3.chart.PointRenderer");jsx3.Class.defineClass("jsx3.chart.PlotSeries",jsx3.chart.Series,null,function(m,g){m.O1=25;g.init=function(c,j){this.jsxsuper(c,j);this.xField=null;this.yField=null;this.magnitude=null;this.renderer="jsx3.chart.PointRenderer.CIRCLE";};g.Tz=function(){var
Yb=this.pk("Xg");if(Yb==null){Yb=[];this.tm("Xg",Yb);}return Yb;};g.updateView=function(){this.jsxsuper();var
Lc=this.Rk();var
Db=this.ck(Lc);this.tm("gi",Lc);this.tm("bh",Db);var
V=this.Tz();for(var
fc=0;fc<V.length;fc++)this.fv(V[fc]);};g.jE=function(b,l,j,f,c){var
Kb=this.tf();var
Nc=this.getChart();if(Nc==null)return;var
_=Nc.getMaxPointRadius();var
rb=this.getWidth();var
nc=this.getHeight();if(j>rb||j<0)return;if(f>nc||f<0)return;var
uc=this.getRenderer();if(uc==null)uc=jsx3.chart.PointRenderer.CIRCLE;var
Ic=null,Ib=null,xb=null,x=null;var
tb=Nc.getMagnitudeMethod();if(tb=="diameter"){c=Math.min(_*2,c);Ic=j-Math.round(c/2);Ib=f-Math.round(c/2);xb=Ic+c;x=Ib+c;}else{var
jb=tb=="area"?uc.areaToRadius(c*m.O1):c;jb=Math.min(_,jb);Ic=j-Math.round(jb);Ib=f-Math.round(jb);xb=Ic+Math.round(2*jb);x=Ib+Math.round(2*jb);}var
A=this.getColorFunction();var
dc=A!=null?A.call(null,b,l):this.pk("gi");var
yb=uc.render(Ic,Ib,xb,x,dc,this.pk("bh"));yb.setId(this.getId()+"_p"+l);this.th(yb,l,b.getAttribute("jsxid"));Kb.appendChild(yb);var
_b=this.getTooltipFunction();if(_b!=null)yb.setToolTip(_b.call(null,this,b));};g.ui=function(){var
E=this.Tz();E.splice(0,E.length);};g.getXValue=function(d){if(this.xField)return jsx3.chart.asNumber(d.getAttribute(this.xField));return null;};g.getYValue=function(r){if(this.yField)return jsx3.chart.asNumber(r.getAttribute(this.yField));return null;};g.getXField=function(){return this.xField;};g.setXField=function(f){this.xField=f;};g.getYField=function(){return this.yField;};g.setYField=function(n){this.yField=n;};g.getRenderer=function(){return this.Sm("renderer");};g.setRenderer=function(h){this.Dd("renderer",h);};g.getLegendRenderer=function(){var
cb=this.getRenderer();return cb!=null?cb:this.jsxsuper();};m.getVersion=function(){return jsx3.chart.sj;};});jsx3.Class.defineClass("jsx3.chart.PointSeries",jsx3.chart.PlotSeries,null,function(s,k){s.DEFAULT_MAGNITUDE=4;k.init=function(e,h){this.jsxsuper(e,h);this.magnitude=null;this.setTooltipFunction("jsx3.chart.PointSeries.tooltip");};k.Co=function(o,f,m,l){this.Tz().push([o,f,m,l]);};k.fv=function(g){this.jE(g[0],g[1],g[2],g[3],this.getMagnitude());};k.getMagnitude=function(){return this.magnitude!=null?this.magnitude:s.DEFAULT_MAGNITUDE;};k.setMagnitude=function(b){this.magnitude=b;};k.toString=function(){return "[PointSeries '"+this.getName()+"']";};s.tooltip=function(g,f){var
db=g.getXValue(f);var
V=g.getYValue(f);return "{"+db+","+V+"}";};});jsx3.Class.defineClass("jsx3.chart.BubbleSeries",jsx3.chart.PlotSeries,null,function(i,e){e.init=function(c,j){this.jsxsuper(c,j);this.magnitudeField=null;this.setTooltipFunction("jsx3.chart.BubbleSeries.tooltip");};e.Co=function(b,l,g,f,c){this.Tz().push([b,l,g,f,c]);};e.fv=function(r){this.jE(r[0],r[1],r[2],r[3],r[4]);};e.toString=function(){return "[BubbleSeries '"+this.getName()+"']";};i.tooltip=function(n,l){var
u=n.getXValue(l);var
ic=n.getYValue(l);var
v=n.getMagnitudeValue(l);return "{"+u+","+ic+","+v+"}";};e.getMagnitudeField=function(){return this.magnitudeField;};e.setMagnitudeField=function(p){this.magnitudeField=p;};e.getMagnitudeValue=function(o){if(this.magnitudeField)return jsx3.chart.asNumber(o.getAttribute(this.magnitudeField));return null;};});
