/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Axis");jsx3.Class.defineClass("jsx3.chart.LinearAxis",jsx3.chart.Axis,null,function(n,d){n.MIN_INTERVALS=5;n.MAX_INTERVALS=11;n.MAX_TICKS=200;n.l0=1.1;n.sV=0;n.Pp=100;n.FY=20;d.init=function(e,c,r){this.jsxsuper(e,c,r);this.autoAdjust=jsx3.Boolean.TRUE;this.baseAtZero=jsx3.Boolean.TRUE;this.min=null;this.max=null;this.interval=null;this.tm("jn",n.sV);this.tm("dk",n.Pp);this.tm("bo",n.FY);};d.getAutoAdjust=function(){return this.autoAdjust;};d.setAutoAdjust=function(j){this.autoAdjust=j;};d.getBaseAtZero=function(){return this.baseAtZero;};d.setBaseAtZero=function(i){this.baseAtZero=i;};d.getMin=function(){return this.min;};d.setMin=function(q){this.min=q;};d.getMax=function(){return this.max;};d.setMax=function(k){this.max=k;};d.getInterval=function(){return this.interval;};d.setInterval=function(c){this.interval=c;};d.ve=function(){var
ob=false;if(this.autoAdjust)ob=this.tX();if(!ob){this.tm("jn",this.min!=null?this.min:n.sV);this.tm("dk",this.max!=null?this.max:n.Pp);this.tm("bo",this.interval!=null?this.interval:n.FY);}};d.tX=function(){var
qb=this.getChart();if(qb==null)return false;var
Ic=qb.getRangeForAxis(this);var
bc,Ab;if(Ic==null){jsx3.chart.LOG.debug("no range for axis "+this+" in chart "+qb);if(this.min!=null||this.max!=null){bc=this.min||n.sV;Ab=this.max||bc+n.Pp;}else return false;}else{bc=Ic[0];Ab=Ic[1];}var
ic=null,B=null,R=null;if(this.min!=null)ic=this.min;else if(bc>=0&&this.baseAtZero)ic=0;if(this.max!=null)B=this.max;else if(Ab<=0&&this.baseAtZero)B=0;R=this.interval;if(R==null){var
Ub=1;var
y=null,K=null;if(ic!=null){y=ic;}else{y=bc;Ub=Ub*n.l0;}if(B!=null){K=B;}else{K=Ab;Ub=Ub*n.l0;}var
xc=K-y;var
pb=xc*Ub;R=1;if(pb>0){pb=pb/n.MIN_INTERVALS;while(pb<1){R=R/10;pb=pb*10;}while(pb>10){R=R*10;pb=pb/10;}if(pb>5){R=R*5;}else if(pb>2)R=R*2;}}if(ic==null){var
Cb=bc-(n.l0-1)*(Ab-bc)/2;ic=R*Math.floor(Cb/R);if(B!=null)ic=ic-B%R;}if(B==null){var
uc=Ab+(n.l0-1)*(Ab-bc)/2;B=R*Math.ceil(uc/R);if(ic!=null)B=B+ic%R;}this.tm("jn",ic);this.tm("dk",B);this.tm("bo",R);return true;};d.af=function(h){return this.pk("jn")+h*this.pk("bo");};d.yf=function(){var
Mb=this.pk("dk");var
Yb=this.pk("jn");var
W=this.pk("bo");var
Hc=[];var
Cb=Yb;while(Cb<=Mb&&Hc.length<n.MAX_TICKS){Hc.push(this.getCoordinateFor(Cb));Cb=Cb+W;}return Hc;};d.Kk=function(){return this.pk("jn")<0&&this.pk("dk")>0;};d.getCoordinateFor=function(m){var
Lc=this.pk("dk");var
Yb=this.pk("jn");if(m<Yb)return this.horizontal?0:this.length;if(m>Lc)return this.horizontal?this.length:0;var
ac=Math.round(this.length*(m-Yb)/(Lc-Yb));return this.horizontal?ac:this.length-ac;};d.getCoordinateForNoClip=function(a){var
N=this.pk("dk");var
jb=this.pk("jn");var
Jc=Math.round(a*1000)/1000;var
W=this.length*((Jc-jb)/(N-jb));return Math.round(this.horizontal?W:this.length-W);};d.toString=function(){return "[LinearAxis '"+this.getName()+"' hor:"+this.horizontal+" pri:"+this.primary+"]";};n.getVersion=function(){return jsx3.chart.sj;};});
