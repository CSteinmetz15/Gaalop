package de.gaalop.tba.generatedTests;

import java.util.HashMap;

public class LinePointDistance implements GAProgram {
	// input variables
	private float p1x$0;
	private float p2y$0;
	private float p2x$0;
	private float p2z$0;
	private float pTsty$0;
	private float p1z$0;
	private float pTstz$0;
	private float p1y$0;
	private float pTstx$0;

	// output variables
	private float L$0;
	private float L$1;
	private float L$2;
	private float L$3;
	private float L$4;
	private float L$5;
	private float L$6;
	private float L$7;
	private float L$8;
	private float L$9;
	private float L$10;
	private float L$11;
	private float L$12;
	private float L$13;
	private float L$14;
	private float L$15;
	private float L$16;
	private float L$17;
	private float L$18;
	private float L$19;
	private float L$20;
	private float L$21;
	private float L$22;
	private float L$23;
	private float L$24;
	private float L$25;
	private float L$26;
	private float L$27;
	private float L$28;
	private float L$29;
	private float L$30;
	private float L$31;
	private float V$0;
	private float V$1;
	private float V$2;
	private float V$3;
	private float V$4;
	private float V$5;
	private float V$6;
	private float V$7;
	private float V$8;
	private float V$9;
	private float V$10;
	private float V$11;
	private float V$12;
	private float V$13;
	private float V$14;
	private float V$15;
	private float V$16;
	private float V$17;
	private float V$18;
	private float V$19;
	private float V$20;
	private float V$21;
	private float V$22;
	private float V$23;
	private float V$24;
	private float V$25;
	private float V$26;
	private float V$27;
	private float V$28;
	private float V$29;
	private float V$30;
	private float V$31;
	private float abstand$0;
	private float abstand$1;
	private float abstand$2;
	private float abstand$3;
	private float abstand$4;
	private float abstand$5;
	private float abstand$6;
	private float abstand$7;
	private float abstand$8;
	private float abstand$9;
	private float abstand$10;
	private float abstand$11;
	private float abstand$12;
	private float abstand$13;
	private float abstand$14;
	private float abstand$15;
	private float abstand$16;
	private float abstand$17;
	private float abstand$18;
	private float abstand$19;
	private float abstand$20;
	private float abstand$21;
	private float abstand$22;
	private float abstand$23;
	private float abstand$24;
	private float abstand$25;
	private float abstand$26;
	private float abstand$27;
	private float abstand$28;
	private float abstand$29;
	private float abstand$30;
	private float abstand$31;
	private float nor$0;
	private float nor$1;
	private float nor$2;
	private float nor$3;
	private float nor$4;
	private float nor$5;
	private float nor$6;
	private float nor$7;
	private float nor$8;
	private float nor$9;
	private float nor$10;
	private float nor$11;
	private float nor$12;
	private float nor$13;
	private float nor$14;
	private float nor$15;
	private float nor$16;
	private float nor$17;
	private float nor$18;
	private float nor$19;
	private float nor$20;
	private float nor$21;
	private float nor$22;
	private float nor$23;
	private float nor$24;
	private float nor$25;
	private float nor$26;
	private float nor$27;
	private float nor$28;
	private float nor$29;
	private float nor$30;
	private float nor$31;

	@Override
	public float getValue(String varName) {
		if (varName.equals("L$0")) return L$0;
		if (varName.equals("L$1")) return L$1;
		if (varName.equals("L$2")) return L$2;
		if (varName.equals("L$3")) return L$3;
		if (varName.equals("L$4")) return L$4;
		if (varName.equals("L$5")) return L$5;
		if (varName.equals("L$6")) return L$6;
		if (varName.equals("L$7")) return L$7;
		if (varName.equals("L$8")) return L$8;
		if (varName.equals("L$9")) return L$9;
		if (varName.equals("L$10")) return L$10;
		if (varName.equals("L$11")) return L$11;
		if (varName.equals("L$12")) return L$12;
		if (varName.equals("L$13")) return L$13;
		if (varName.equals("L$14")) return L$14;
		if (varName.equals("L$15")) return L$15;
		if (varName.equals("L$16")) return L$16;
		if (varName.equals("L$17")) return L$17;
		if (varName.equals("L$18")) return L$18;
		if (varName.equals("L$19")) return L$19;
		if (varName.equals("L$20")) return L$20;
		if (varName.equals("L$21")) return L$21;
		if (varName.equals("L$22")) return L$22;
		if (varName.equals("L$23")) return L$23;
		if (varName.equals("L$24")) return L$24;
		if (varName.equals("L$25")) return L$25;
		if (varName.equals("L$26")) return L$26;
		if (varName.equals("L$27")) return L$27;
		if (varName.equals("L$28")) return L$28;
		if (varName.equals("L$29")) return L$29;
		if (varName.equals("L$30")) return L$30;
		if (varName.equals("L$31")) return L$31;
		if (varName.equals("V$0")) return V$0;
		if (varName.equals("V$1")) return V$1;
		if (varName.equals("V$2")) return V$2;
		if (varName.equals("V$3")) return V$3;
		if (varName.equals("V$4")) return V$4;
		if (varName.equals("V$5")) return V$5;
		if (varName.equals("V$6")) return V$6;
		if (varName.equals("V$7")) return V$7;
		if (varName.equals("V$8")) return V$8;
		if (varName.equals("V$9")) return V$9;
		if (varName.equals("V$10")) return V$10;
		if (varName.equals("V$11")) return V$11;
		if (varName.equals("V$12")) return V$12;
		if (varName.equals("V$13")) return V$13;
		if (varName.equals("V$14")) return V$14;
		if (varName.equals("V$15")) return V$15;
		if (varName.equals("V$16")) return V$16;
		if (varName.equals("V$17")) return V$17;
		if (varName.equals("V$18")) return V$18;
		if (varName.equals("V$19")) return V$19;
		if (varName.equals("V$20")) return V$20;
		if (varName.equals("V$21")) return V$21;
		if (varName.equals("V$22")) return V$22;
		if (varName.equals("V$23")) return V$23;
		if (varName.equals("V$24")) return V$24;
		if (varName.equals("V$25")) return V$25;
		if (varName.equals("V$26")) return V$26;
		if (varName.equals("V$27")) return V$27;
		if (varName.equals("V$28")) return V$28;
		if (varName.equals("V$29")) return V$29;
		if (varName.equals("V$30")) return V$30;
		if (varName.equals("V$31")) return V$31;
		if (varName.equals("abstand$0")) return abstand$0;
		if (varName.equals("abstand$1")) return abstand$1;
		if (varName.equals("abstand$2")) return abstand$2;
		if (varName.equals("abstand$3")) return abstand$3;
		if (varName.equals("abstand$4")) return abstand$4;
		if (varName.equals("abstand$5")) return abstand$5;
		if (varName.equals("abstand$6")) return abstand$6;
		if (varName.equals("abstand$7")) return abstand$7;
		if (varName.equals("abstand$8")) return abstand$8;
		if (varName.equals("abstand$9")) return abstand$9;
		if (varName.equals("abstand$10")) return abstand$10;
		if (varName.equals("abstand$11")) return abstand$11;
		if (varName.equals("abstand$12")) return abstand$12;
		if (varName.equals("abstand$13")) return abstand$13;
		if (varName.equals("abstand$14")) return abstand$14;
		if (varName.equals("abstand$15")) return abstand$15;
		if (varName.equals("abstand$16")) return abstand$16;
		if (varName.equals("abstand$17")) return abstand$17;
		if (varName.equals("abstand$18")) return abstand$18;
		if (varName.equals("abstand$19")) return abstand$19;
		if (varName.equals("abstand$20")) return abstand$20;
		if (varName.equals("abstand$21")) return abstand$21;
		if (varName.equals("abstand$22")) return abstand$22;
		if (varName.equals("abstand$23")) return abstand$23;
		if (varName.equals("abstand$24")) return abstand$24;
		if (varName.equals("abstand$25")) return abstand$25;
		if (varName.equals("abstand$26")) return abstand$26;
		if (varName.equals("abstand$27")) return abstand$27;
		if (varName.equals("abstand$28")) return abstand$28;
		if (varName.equals("abstand$29")) return abstand$29;
		if (varName.equals("abstand$30")) return abstand$30;
		if (varName.equals("abstand$31")) return abstand$31;
		if (varName.equals("nor$0")) return nor$0;
		if (varName.equals("nor$1")) return nor$1;
		if (varName.equals("nor$2")) return nor$2;
		if (varName.equals("nor$3")) return nor$3;
		if (varName.equals("nor$4")) return nor$4;
		if (varName.equals("nor$5")) return nor$5;
		if (varName.equals("nor$6")) return nor$6;
		if (varName.equals("nor$7")) return nor$7;
		if (varName.equals("nor$8")) return nor$8;
		if (varName.equals("nor$9")) return nor$9;
		if (varName.equals("nor$10")) return nor$10;
		if (varName.equals("nor$11")) return nor$11;
		if (varName.equals("nor$12")) return nor$12;
		if (varName.equals("nor$13")) return nor$13;
		if (varName.equals("nor$14")) return nor$14;
		if (varName.equals("nor$15")) return nor$15;
		if (varName.equals("nor$16")) return nor$16;
		if (varName.equals("nor$17")) return nor$17;
		if (varName.equals("nor$18")) return nor$18;
		if (varName.equals("nor$19")) return nor$19;
		if (varName.equals("nor$20")) return nor$20;
		if (varName.equals("nor$21")) return nor$21;
		if (varName.equals("nor$22")) return nor$22;
		if (varName.equals("nor$23")) return nor$23;
		if (varName.equals("nor$24")) return nor$24;
		if (varName.equals("nor$25")) return nor$25;
		if (varName.equals("nor$26")) return nor$26;
		if (varName.equals("nor$27")) return nor$27;
		if (varName.equals("nor$28")) return nor$28;
		if (varName.equals("nor$29")) return nor$29;
		if (varName.equals("nor$30")) return nor$30;
		if (varName.equals("nor$31")) return nor$31;
		return 0.0f;
	}

	@Override
	public HashMap<String,Float> getValues() {
		HashMap<String,Float> result = new HashMap<String,Float>();
		result.put("L$0",L$0);
		result.put("L$1",L$1);
		result.put("L$2",L$2);
		result.put("L$3",L$3);
		result.put("L$4",L$4);
		result.put("L$5",L$5);
		result.put("L$6",L$6);
		result.put("L$7",L$7);
		result.put("L$8",L$8);
		result.put("L$9",L$9);
		result.put("L$10",L$10);
		result.put("L$11",L$11);
		result.put("L$12",L$12);
		result.put("L$13",L$13);
		result.put("L$14",L$14);
		result.put("L$15",L$15);
		result.put("L$16",L$16);
		result.put("L$17",L$17);
		result.put("L$18",L$18);
		result.put("L$19",L$19);
		result.put("L$20",L$20);
		result.put("L$21",L$21);
		result.put("L$22",L$22);
		result.put("L$23",L$23);
		result.put("L$24",L$24);
		result.put("L$25",L$25);
		result.put("L$26",L$26);
		result.put("L$27",L$27);
		result.put("L$28",L$28);
		result.put("L$29",L$29);
		result.put("L$30",L$30);
		result.put("L$31",L$31);
		result.put("V$0",V$0);
		result.put("V$1",V$1);
		result.put("V$2",V$2);
		result.put("V$3",V$3);
		result.put("V$4",V$4);
		result.put("V$5",V$5);
		result.put("V$6",V$6);
		result.put("V$7",V$7);
		result.put("V$8",V$8);
		result.put("V$9",V$9);
		result.put("V$10",V$10);
		result.put("V$11",V$11);
		result.put("V$12",V$12);
		result.put("V$13",V$13);
		result.put("V$14",V$14);
		result.put("V$15",V$15);
		result.put("V$16",V$16);
		result.put("V$17",V$17);
		result.put("V$18",V$18);
		result.put("V$19",V$19);
		result.put("V$20",V$20);
		result.put("V$21",V$21);
		result.put("V$22",V$22);
		result.put("V$23",V$23);
		result.put("V$24",V$24);
		result.put("V$25",V$25);
		result.put("V$26",V$26);
		result.put("V$27",V$27);
		result.put("V$28",V$28);
		result.put("V$29",V$29);
		result.put("V$30",V$30);
		result.put("V$31",V$31);
		result.put("abstand$0",abstand$0);
		result.put("abstand$1",abstand$1);
		result.put("abstand$2",abstand$2);
		result.put("abstand$3",abstand$3);
		result.put("abstand$4",abstand$4);
		result.put("abstand$5",abstand$5);
		result.put("abstand$6",abstand$6);
		result.put("abstand$7",abstand$7);
		result.put("abstand$8",abstand$8);
		result.put("abstand$9",abstand$9);
		result.put("abstand$10",abstand$10);
		result.put("abstand$11",abstand$11);
		result.put("abstand$12",abstand$12);
		result.put("abstand$13",abstand$13);
		result.put("abstand$14",abstand$14);
		result.put("abstand$15",abstand$15);
		result.put("abstand$16",abstand$16);
		result.put("abstand$17",abstand$17);
		result.put("abstand$18",abstand$18);
		result.put("abstand$19",abstand$19);
		result.put("abstand$20",abstand$20);
		result.put("abstand$21",abstand$21);
		result.put("abstand$22",abstand$22);
		result.put("abstand$23",abstand$23);
		result.put("abstand$24",abstand$24);
		result.put("abstand$25",abstand$25);
		result.put("abstand$26",abstand$26);
		result.put("abstand$27",abstand$27);
		result.put("abstand$28",abstand$28);
		result.put("abstand$29",abstand$29);
		result.put("abstand$30",abstand$30);
		result.put("abstand$31",abstand$31);
		result.put("nor$0",nor$0);
		result.put("nor$1",nor$1);
		result.put("nor$2",nor$2);
		result.put("nor$3",nor$3);
		result.put("nor$4",nor$4);
		result.put("nor$5",nor$5);
		result.put("nor$6",nor$6);
		result.put("nor$7",nor$7);
		result.put("nor$8",nor$8);
		result.put("nor$9",nor$9);
		result.put("nor$10",nor$10);
		result.put("nor$11",nor$11);
		result.put("nor$12",nor$12);
		result.put("nor$13",nor$13);
		result.put("nor$14",nor$14);
		result.put("nor$15",nor$15);
		result.put("nor$16",nor$16);
		result.put("nor$17",nor$17);
		result.put("nor$18",nor$18);
		result.put("nor$19",nor$19);
		result.put("nor$20",nor$20);
		result.put("nor$21",nor$21);
		result.put("nor$22",nor$22);
		result.put("nor$23",nor$23);
		result.put("nor$24",nor$24);
		result.put("nor$25",nor$25);
		result.put("nor$26",nor$26);
		result.put("nor$27",nor$27);
		result.put("nor$28",nor$28);
		result.put("nor$29",nor$29);
		result.put("nor$30",nor$30);
		result.put("nor$31",nor$31);
		return result;
	}
	@Override
	public boolean setValue(String varName, float value) {
		if (varName.equals("p1x$0")) { p1x$0 = value; return true; }
		if (varName.equals("p2y$0")) { p2y$0 = value; return true; }
		if (varName.equals("p2x$0")) { p2x$0 = value; return true; }
		if (varName.equals("p2z$0")) { p2z$0 = value; return true; }
		if (varName.equals("pTsty$0")) { pTsty$0 = value; return true; }
		if (varName.equals("p1z$0")) { p1z$0 = value; return true; }
		if (varName.equals("pTstz$0")) { pTstz$0 = value; return true; }
		if (varName.equals("p1y$0")) { p1y$0 = value; return true; }
		if (varName.equals("pTstx$0")) { pTstx$0 = value; return true; }
		return false;
	}
	
	@Override
	public void calculate() {
		vTst$4 = ((((pTstx$0 * pTstx$0) + ((pTsty$0 * pTsty$0) + (pTstz$0 * pTstz$0)))) / 2.0f); // einf;
		L$6 = (p1z$0 + (-p2z$0)); // e1^e2;
		L$7 = (-((p1y$0 + (-p2y$0)))); // e1^e3;
		L$8 = (-(((p1y$0 * p2z$0) + (-((p1z$0 * p2y$0)))))); // e1^einf;
		L$10 = (p1x$0 + (-p2x$0)); // e2^e3;
		L$11 = ((p1x$0 * p2z$0) + (-((p1z$0 * p2x$0)))); // e2^einf;
		L$13 = (-(((p1x$0 * p2y$0) + (-((p1y$0 * p2x$0)))))); // e3^einf;
		La$6 = (L$6 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e1^e2;
		La$7 = (L$7 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e1^e3;
		La$8 = (L$8 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e1^einf;
		La$10 = (L$10 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e2^e3;
		La$11 = (L$11 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e2^einf;
		La$13 = (L$13 * ((float) Math.sqrt((float) Math.abs((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))) / (float) Math.sqrt((float) Math.abs((((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10)))))) * ((((-((L$6 * (-L$6)))) + (-((L$7 * (-L$7))))) + (-((L$10 * (-L$10))))))))))); // e3^einf;
		R$0 = (float) Math.cos(0.785398f); // 1.0;
		R$6 = (-((La$6 * (float) Math.sin(0.785398f)))); // e1^e2;
		R$7 = (-((La$7 * (float) Math.sin(0.785398f)))); // e1^e3;
		R$8 = (-((La$8 * (float) Math.sin(0.785398f)))); // e1^einf;
		R$10 = (-((La$10 * (float) Math.sin(0.785398f)))); // e2^e3;
		R$11 = (-((La$11 * (float) Math.sin(0.785398f)))); // e2^einf;
		R$13 = (-((La$13 * (float) Math.sin(0.785398f)))); // e3^einf;
		V$1 = ((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * R$0) + (-(((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$6))))) + (-(((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$7))))) + (R$0 * (-R$8))) + (-((((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$10))))) + (R$6 * (-R$11))) + (R$7 * (-R$13))); // e1;
		V$2 = ((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$6)) + ((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * R$0)) + (-(((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$10))))) + (R$0 * (-R$11))) + (((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$7))) + (-((R$6 * (-R$8))))) + (R$10 * (-R$13))); // e2;
		V$3 = ((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$7)) + ((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$10))) + ((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * R$0)) + (R$0 * (-R$13))) + (-((((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$6))))) + (-((R$7 * (-R$8))))) + (-((R$10 * (-R$11))))); // e3;
		V$4 = (((((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$8)) + ((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$11))) + ((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$13))) + ((((((R$0 * vTst$4) + (-((R$8 * pTstx$0)))) + (-((R$11 * pTsty$0)))) + (-((R$13 * pTstz$0))))) * R$0)) + (-((((((R$6 * vTst$4) + (-((R$8 * pTsty$0)))) + (R$11 * pTstx$0))) * (-R$6))))) + (-((((((R$7 * vTst$4) + (-((R$8 * pTstz$0)))) + (R$13 * pTstx$0))) * (-R$7))))) + (-((R$8 * (-R$8))))) + (-((((((R$10 * vTst$4) + (-((R$11 * pTstz$0)))) + (R$13 * pTsty$0))) * (-R$10))))) + (-((R$11 * (-R$11))))) + (-((R$13 * (-R$13))))); // einf;
		V$5 = ((((R$0 * R$0) + (-((R$6 * (-R$6))))) + (-((R$7 * (-R$7))))) + (-((R$10 * (-R$10))))); // e0;
		V$16 = ((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$10)) + (-(((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$7))))) + ((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$6))) + (((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * R$0)) + (R$6 * (-R$13))) + (-((R$7 * (-R$11))))) + (R$10 * (-R$8))); // e1^e2^e3;
		V$17 = ((((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$11)) + (-(((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$8))))) + ((((((R$0 * vTst$4) + (-((R$8 * pTstx$0)))) + (-((R$11 * pTsty$0)))) + (-((R$13 * pTstz$0))))) * (-R$6))) + (((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$13))) + (((((R$6 * vTst$4) + (-((R$8 * pTsty$0)))) + (R$11 * pTstx$0))) * R$0)) + (-((((((R$7 * vTst$4) + (-((R$8 * pTstz$0)))) + (R$13 * pTstx$0))) * (-R$10))))) + (-((R$8 * (-R$11))))) + (((((R$10 * vTst$4) + (-((R$11 * pTstz$0)))) + (R$13 * pTsty$0))) * (-R$7))) + (R$11 * (-R$8))); // e1^e2^einf;
		V$18 = ((((R$0 * (-R$6)) + (R$6 * R$0)) + (-((R$7 * (-R$10))))) + (R$10 * (-R$7))); // e1^e2^e0;
		V$19 = ((((((((((((((R$0 * pTstx$0) + (R$6 * pTsty$0)) + (R$7 * pTstz$0)) + (-R$8))) * (-R$13)) + (-(((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$8))))) + ((((((R$0 * vTst$4) + (-((R$8 * pTstx$0)))) + (-((R$11 * pTsty$0)))) + (-((R$13 * pTstz$0))))) * (-R$7))) + (-((((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$11))))) + (((((R$6 * vTst$4) + (-((R$8 * pTsty$0)))) + (R$11 * pTstx$0))) * (-R$10))) + (((((R$7 * vTst$4) + (-((R$8 * pTstz$0)))) + (R$13 * pTstx$0))) * R$0)) + (-((R$8 * (-R$13))))) + (-((((((R$10 * vTst$4) + (-((R$11 * pTstz$0)))) + (R$13 * pTsty$0))) * (-R$6))))) + (R$13 * (-R$8))); // e1^e3^einf;
		V$20 = ((((R$0 * (-R$7)) + (R$6 * (-R$10))) + (R$7 * R$0)) + (-((R$10 * (-R$6))))); // e1^e3^e0;
		V$21 = ((((((R$0 * (-R$8)) + (R$6 * (-R$11))) + (R$7 * (-R$13))) + (R$8 * R$0)) + (-((R$11 * (-R$6))))) + (-((R$13 * (-R$7))))); // e1^einf^e0;
		V$22 = ((((((((((((((R$0 * pTsty$0) + (-((R$6 * pTstx$0)))) + (R$10 * pTstz$0)) + (-R$11))) * (-R$13)) + (-(((((((R$0 * pTstz$0) + (-((R$7 * pTstx$0)))) + (-((R$10 * pTsty$0)))) + (-R$13))) * (-R$11))))) + ((((((R$0 * vTst$4) + (-((R$8 * pTstx$0)))) + (-((R$11 * pTsty$0)))) + (-((R$13 * pTstz$0))))) * (-R$10))) + (((((R$6 * pTstz$0) + (-((R$7 * pTsty$0)))) + (R$10 * pTstx$0))) * (-R$8))) + (-((((((R$6 * vTst$4) + (-((R$8 * pTsty$0)))) + (R$11 * pTstx$0))) * (-R$7))))) + (((((R$7 * vTst$4) + (-((R$8 * pTstz$0)))) + (R$13 * pTstx$0))) * (-R$6))) + (((((R$10 * vTst$4) + (-((R$11 * pTstz$0)))) + (R$13 * pTsty$0))) * R$0)) + (-((R$11 * (-R$13))))) + (R$13 * (-R$11))); // e2^e3^einf;
		V$23 = ((((R$0 * (-R$10)) + (-((R$6 * (-R$7))))) + (R$7 * (-R$6))) + (R$10 * R$0)); // e2^e3^e0;
		V$24 = ((((((R$0 * (-R$11)) + (-((R$6 * (-R$8))))) + (R$8 * (-R$6))) + (R$10 * (-R$13))) + (R$11 * R$0)) + (-((R$13 * (-R$10))))); // e2^einf^e0;
		V$25 = ((((((R$0 * (-R$13)) + (-((R$7 * (-R$8))))) + (R$8 * (-R$7))) + (-((R$10 * (-R$11))))) + (R$11 * (-R$10))) + (R$13 * R$0)); // e3^einf^e0;
		V$31 = ((((((R$6 * (-R$13)) + (-((R$7 * (-R$11))))) + (R$8 * (-R$10))) + (R$10 * (-R$8))) + (-((R$11 * (-R$7))))) + (R$13 * (-R$6))); // e1^e2^e3^einf^e0;
		P$1 = (-(((((((p1y$0 * p2z$0) + (-((p1z$0 * p2y$0))))) * V$5) + (-((((p1y$0 + (-p2y$0))) * V$3)))) + (((p1z$0 + (-p2z$0))) * V$2)))); // e1;
		P$2 = ((((((p1x$0 * p2z$0) + (-((p1z$0 * p2x$0))))) * V$5) + (-((((p1x$0 + (-p2x$0))) * V$3)))) + (((p1z$0 + (-p2z$0))) * V$1)); // e2;
		P$3 = (-(((((((p1x$0 * p2y$0) + (-((p1y$0 * p2x$0))))) * V$5) + (-((((p1x$0 + (-p2x$0))) * V$2)))) + (((p1y$0 + (-p2y$0))) * V$1)))); // e3;
		P$4 = (-(((((((p1x$0 * p2y$0) + (-((p1y$0 * p2x$0))))) * V$3) + (-(((((p1x$0 * p2z$0) + (-((p1z$0 * p2x$0))))) * V$2)))) + ((((p1y$0 * p2z$0) + (-((p1z$0 * p2y$0))))) * V$1)))); // einf;
		Pa$1 = (P$1 * ((float) Math.sqrt((float) Math.abs((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))) / (float) Math.sqrt((float) Math.abs((((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3))) * ((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))))))); // e1;
		Pa$2 = (P$2 * ((float) Math.sqrt((float) Math.abs((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))) / (float) Math.sqrt((float) Math.abs((((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3))) * ((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))))))); // e2;
		Pa$3 = (P$3 * ((float) Math.sqrt((float) Math.abs((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))) / (float) Math.sqrt((float) Math.abs((((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3))) * ((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))))))); // e3;
		Pa$4 = (P$4 * ((float) Math.sqrt((float) Math.abs((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))) / (float) Math.sqrt((float) Math.abs((((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3))) * ((((P$1 * P$1) + (P$2 * P$2)) + (P$3 * P$3)))))))); // einf;
		abstand$0 = (float) Math.sqrt((float) Math.abs(((((((Pa$1 * pTstx$0) + (Pa$2 * pTsty$0)) + (Pa$3 * pTstz$0)) + (-Pa$4))) * (((((Pa$1 * pTstx$0) + (Pa$2 * pTsty$0)) + (Pa$3 * pTstz$0)) + (-Pa$4)))))); // 1.0;
		nor$1 = Pa$1; // e1;
		nor$2 = Pa$2; // e2;
		nor$3 = Pa$3; // e3;
		nor$4 = (Pa$4 + (-Pa$4)); // einf;
	}

	private float P$2;
	private float La$11;
	private float R$6;
	private float P$3;
	private float La$10;
	private float R$7;
	private float R$8;
	private float P$1;
	private float Pa$4;
	private float La$8;
	private float Pa$3;
	private float La$7;
	private float La$6;
	private float vTst$4;
	private float R$11;
	private float R$10;
	private float R$13;
	private float Pa$1;
	private float Pa$2;
	private float R$0;
	private float P$4;
	private float La$13;

}