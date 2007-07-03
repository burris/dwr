/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Series");jsx3.Class.defineClass("jsx3.chart.BCSeries",jsx3.chart.Series,null,function(l,d){d.init=function(c,a){this.jsxsuper(c,a);this.xField=null;this.yField=null;this.minField=null;};d.Cd=jsx3.Method.newAbstract();d.So=jsx3.Method.newAbstract();d.an=jsx3.Method.newAbstract();d.getXValue=function(q){if(this.xField)return jsx3.chart.asNumber(q.getAttribute(this.xField));return null;};d.getYValue=function(p){if(this.yField)return jsx3.chart.asNumber(p.getAttribute(this.yField));return null;};d.getMinValue=function(b){if(this.minField)return jsx3.chart.asNumber(b.getAttribute(this.minField));return null;};d.getShownAreas=function(){var
Q=this.pk("Fh");if(Q==null){Q=[];this.tm("Fh",Q);}return Q;};d.updateView=function(){this.jsxsuper();var
sb=this.Rk();var
R=this.ck(sb);this.tm("gi",sb);this.tm("bh",R);var
w=this.getShownAreas();for(var
U=0;U<w.length;U++){var
vb=w[U];this.ao(vb[0],vb[1],vb[2],vb[3],vb[4],vb[5],true);}};d.ao=function(e,o,c,j,b,i,h){if(!h)this.getShownAreas().push([e,o,c,j,b,i]);var
ib=this.tf();var
Xb=this.getWidth();var
Pb=this.getHeight();if(c>b){var
U=c;c=b;b=U;}if(j>i){var
U=j;j=i;i=U;}if(c>Xb||b<0)return;if(j>Pb||i<0)return;var
H=new
jsx3.vector.Rectangle(c,j,b-c,i-j);H.setId(this.getId()+"_r"+o);H.Hp(0,0,Xb,Pb);var
Mb=this.getColorFunction();var
fb=Mb!=null?Mb.call(null,e,o):this.pk("gi");H.setFill(fb);H.setStroke(this.pk("bh"));var
Lc=this.getTooltipFunction();if(Lc!=null)H.setToolTip(Lc.call(null,this,e));this.th(H,o,e.getAttribute("jsxid"));ib.appendChild(H);};d.Df=function(){var
cb=this.getShownAreas();cb.splice(0,cb.length);};d.getXField=function(){return this.xField;};d.setXField=function(q){this.xField=q;};d.getYField=function(){return this.yField;};d.setYField=function(k){this.yField=k;};d.getMinField=function(){return this.minField;};d.setMinField=function(j){this.minField=j;};l.getVersion=function(){return jsx3.chart.sj;};});jsx3.chart.BCSeries.prototype.drawBar=jsx3.chart.BCSeries.prototype.ao;jsx3.chart.BCSeries.prototype.drawColumn=jsx3.chart.BCSeries.prototype.ao;jsx3.Class.defineClass("jsx3.chart.BarSeries",jsx3.chart.BCSeries,null,function(k,a){k.DEFAULT_BARHEIGHT=10;a.init=function(b,m){this.jsxsuper(b,m);this.barHeight=null;this.setTooltipFunction("jsx3.chart.BarSeries.tooltip");};a.Cd=function(o){return this.getXValue(o);};a.So=function(l){return this.getYValue(l);};a.an=function(){return this.getBarHeight();};a.getBarHeight=function(){return this.barHeight!=null?this.barHeight:k.DEFAULT_BARHEIGHT;};a.setBarHeight=function(j){this.barHeight=j;};a.toString=function(){return "[BarSeries '"+this.getName()+"']";};k.tooltip=function(r,h){var
qc=r.getXValue(h);var
Bb=r.getYValue(h);var
vc=r.getMinValue(h);var
Nc=vc!=null?"{"+vc+","+qc+"}":qc;if(Bb!=null)Nc=Nc+(", y = "+Bb);return Nc;};});jsx3.Class.defineClass("jsx3.chart.ColumnSeries",jsx3.chart.BCSeries,null,function(p,k){p.DEFAULT_COLUMNWIDTH=10;k.init=function(o,q){this.jsxsuper(o,q);this.columnWidth=null;this.setTooltipFunction("jsx3.chart.ColumnSeries.tooltip");};k.Cd=function(l){return this.getYValue(l);};k.So=function(q){return this.getXValue(q);};k.an=function(){return this.getColumnWidth();};k.getColumnWidth=function(){return this.columnWidth!=null?this.columnWidth:p.DEFAULT_COLUMNWIDTH;};k.setColumnWidth=function(q){this.columnWidth=q;};k.toString=function(){return "[ColumnSeries '"+this.getName()+"']";};k.ao=function(h,r,a,f,s,e,n){if(n)this.jsxsuper(h,r,a,f,s,e,n);else this.jsxsuper(h,r,f,s,e,a,n);};p.tooltip=function(d,c){var
lc=d.getXValue(c);var
Cc=d.getYValue(c);var
xc=d.getMinValue(c);var
Ec=xc!=null?"{"+xc+","+Cc+"}":Cc;if(lc!=null)Ec=Ec+(", x = "+lc);return Ec;};});
