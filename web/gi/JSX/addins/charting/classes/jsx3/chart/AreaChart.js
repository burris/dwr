/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.CartesianChart","jsx3.chart.AreaSeries");jsx3.Class.defineClass("jsx3.chart.AreaChart",jsx3.chart.CartesianChart,null,function(r,q){r.TYPE_OVERLAY="overlay";r.TYPE_STACKED="stacked";r.TYPE_STACKED100="stacked100";q.init=function(h,l,o,i,p){this.jsxsuper(h,l,o,i,p);this.type="overlay";};q.getType=function(){return this.type;};q.setType=function(h){if(r.ALLOWED_TYPES[h]){this.type=h;}else throw new
jsx3.IllegalArgumentException("type",h);};q.getYRange=function(e){if(this.type=="overlay"){return this.getRangeForField(e,"getYValue");}else if(this.type=="stacked"){return this.getStackedRangeForField(e,"getYValue");}else if(this.type=="stacked100"){return this.getStacked100RangeForField(e,"getYValue");}else{jsx3.chart.LOG.error("unsupported Line Chart type: "+this.type);return null;}};q.getXRange=function(i){return this.getRangeForField(i,"getXValue");};q.updateView=function(){this.jsxsuper();this.ug();};q.ug=function(){var
Zb=this.wg();var
Db=this.Cm();var
hb=this.bi();var
Cc=this.getPrimaryXAxis();var
L=this.getPrimaryYAxis();if(Cc==null||L==null||Db.length==0||hb==null)return;if(!jsx3.chart.isValueAxis(L)){jsx3.chart.LOG.error("bad y axis type: "+L.getClass());return;}var
kb=null;if(this.type=="stacked100")kb=this.kk(Db,"getYValue");var
_=null,rb=null;if(this.type=="stacked"||this.type=="stacked100"){_=new
Array(hb.length);rb=new
Array(hb.length);for(var
X=0;X<hb.length;X++)_[X]=rb[X]=0;}for(var
Bb=0;Bb<Db.length;Bb++){var
ib=Db[Bb];ib.ui();for(var
X=0;X<hb.length;X++){var
bb=hb[X];var
ac=null,D=null,Gb=null;var
Pb=ib.getYValue(bb);var
pc=ib.getMinValue(bb);if(Pb==null)continue;if(this.type=="stacked"||this.type=="stacked100"){if(Pb>=0){pc=_[X];Pb=_[X]+Pb;_[X]=Pb;}else{pc=rb[X];Pb=rb[X]+Pb;rb[X]=Pb;}if(this.type=="stacked100"){Pb=100*(Pb/kb[X]);pc=100*(pc/kb[X]);}}if(pc==null)pc=0;D=L.getCoordinateForNoClip(Pb);Gb=L.getCoordinateFor(pc);if(jsx3.chart.isValueAxis(Cc)){var
uc=ib.getXValue(bb);if(uc!=null)ac=Cc.getCoordinateForNoClip(uc);}else if(jsx3.chart.isCategoryAxis(Cc))ac=Cc.getPointForCategory(X);if(ac==null)continue;ib.Co(bb,ac,D,X);ib.qp(ac,Gb);}ib.updateView();Zb.appendChild(ib.tf());}};q.ad=function(){return this.type=="stacked"||this.type=="stacked100";};q.zm=function(f){return f instanceof jsx3.chart.AreaSeries;};q.toString=function(){return "[AreaChart '"+this.getName()+"']";};r.getVersion=function(){return jsx3.chart.sj;};});
