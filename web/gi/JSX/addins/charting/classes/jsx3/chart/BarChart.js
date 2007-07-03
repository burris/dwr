/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.CartesianChart","jsx3.chart.BarSeries");jsx3.Class.defineClass("jsx3.chart.BCChart",jsx3.chart.CartesianChart,null,function(d,k){d.TYPE_CLUSTERED="clustered";d.TYPE_STACKED="stacked";d.TYPE_STACKED100="stacked100";d.pL={clustered:1,stacked:1,stacked100:1};k.init=function(f,j,m,l,n){this.jsxsuper(f,j,m,l,n);this.type="clustered";this.seriesOverlap=0;this.categoryCoverage=0.65;};k.getType=function(){return this.type;};k.setType=function(j){if(d.pL[j])this.type=j;else throw new
jsx3.IllegalArgumentException("type",j);};k.getSeriesOverlap=function(){return !isNaN(this.seriesOverlap)?this.seriesOverlap:0;};k.setSeriesOverlap=function(f){this.seriesOverlap=f;};k.getCategoryCoverage=function(){return !isNaN(this.categoryCoverage)?this.categoryCoverage:1;};k.setCategoryCoverage=function(g){this.categoryCoverage=g;};k.Yt=jsx3.Method.newAbstract();k.WX=jsx3.Method.newAbstract();k.kv=function(h,g,j,l,f,m){if(this.type=="stacked"||this.type=="stacked100"){j=0;l=1;}var
kb=g-h;var
Ec=kb*m;var
ab=(h+g)/2;var
Nc=Ec/(l-l*f+f);var
rc=Nc*(j-(l-1)/2)*(1-f);var
L=null;if(j>0&&f==0){var
vc=Nc*(j-1-(l-1)/2)*(1-f);L=Math.round(ab+vc+Nc/2);}else L=Math.round(ab+rc-Nc/2);var
u=Math.round(ab+rc+Nc/2)-1;return [L,u];};k.mF=function(a){if(this.type=="clustered"){var
Qb=this.getRangeForField(a,"Cd");var
Wb=this.getRangeForField(a,"getMinValue");return this.getCombinedRange([Qb,Wb]);}else if(this.type=="stacked"){return this.getStackedRangeForField(a,"Cd");}else if(this.type=="stacked100"){return this.getStacked100RangeForField(a,"Cd");}else{jsx3.chart.LOG.error("unsupported Bar/Column Chart type: "+this.type);return null;}};k.Ns=function(r){return this.getRangeForField(r,"So");};k.updateView=function(){this.jsxsuper();this.ug();};k.ug=function(){var
rc=this.wg();var
nb=this.Cm();var
lb=nb.length;if(lb==0)return;var
Ub=this.bi();var
u=this.Yt();var
kc=this.WX();if(Ub==null||u==null||kc==null)return;if(!jsx3.chart.isValueAxis(u)){jsx3.chart.LOG.error("bad parallel axis type: "+u.getClass());return;}var
U=this.getSeriesOverlap();var
K=this.getCategoryCoverage();var
kb=null;if(this.type=="stacked100")kb=this.kk(nb,"Cd");var
xb=null,eb=null;if(this.type=="stacked"||this.type=="stacked100"){xb=new
Array(Ub.length);eb=new
Array(Ub.length);for(var
bc=0;bc<Ub.length;bc++)xb[bc]=eb[bc]=0;}for(var
bc=0;bc<lb;bc++){var
Lb=nb[bc];Lb.Df();for(var
cb=0;cb<Ub.length;cb++){var
Jb=Ub[cb];var
fb=null,X=null;if(jsx3.chart.isValueAxis(u)){var
Ec=Lb.Cd(Jb);if(this.type=="clustered"){fb=Lb.getMinValue(Jb);if(fb==null)fb=0;X=Ec;if(X==null)continue;}else if(this.type=="stacked"||this.type=="stacked100"){var
Nc=this.type=="stacked"?Ec:100*(Ec/kb[cb]);if(Nc>=0){fb=xb[cb];X=xb[cb]+Nc;xb[cb]=X;}else{fb=eb[cb]+Nc;X=eb[cb];eb[cb]=fb;}}}var
jc=u.getCoordinateForNoClip(fb);if(fb!=0)jc=jc+(u.getHorizontal()?1:-1);var
Hb=u.getCoordinateForNoClip(X);var
I=null,Qb=null;if(jsx3.chart.isValueAxis(kc)){var
ab=Lb.So(Jb);if(ab==null)continue;var
zb=kc.getCoordinateForNoClip(ab);var
mc=Lb.an();I=zb-Math.ceil(mc/2);Qb=zb+Math.floor(mc/2);}else if(jsx3.chart.isCategoryAxis(kc)){var
Ab=kc.getRangeForCategory(cb);var
wb=this.kv(Ab[0],Ab[1],bc,lb,U,K);I=wb[0];Qb=wb[1];}Lb.ao(Jb,cb,jc,I,Hb,Qb);}Lb.updateView();rc.appendChild(Lb.tf());}};d.getVersion=function(){return jsx3.chart.sj;};});jsx3.Class.defineClass("jsx3.chart.BarChart",jsx3.chart.BCChart,null,function(e,n){n.init=function(l,p,s,d,a){this.jsxsuper(l,p,s,d,a);};n.zm=function(h){return h instanceof jsx3.chart.BarSeries;};n.getXRange=function(o){return this.mF(o);};n.getYRange=function(i){return this.Ns(i);};n.Yt=function(){return this.getPrimaryXAxis();};n.WX=function(){return this.getPrimaryYAxis();};n.toString=function(){return "[BarChart '"+this.getName()+"']";};});jsx3.Class.defineClass("jsx3.chart.ColumnChart",jsx3.chart.BCChart,null,function(k,m){m.init=function(d,h,s,l,a){this.jsxsuper(d,h,s,l,a);};m.zm=function(r){return r instanceof jsx3.chart.ColumnSeries;};m.getXRange=function(p){return this.Ns(p);};m.getYRange=function(s){return this.mF(s);};m.Yt=function(){return this.getPrimaryYAxis();};m.WX=function(){return this.getPrimaryXAxis();};m.toString=function(){return "[ColumnChart '"+this.getName()+"']";};});
