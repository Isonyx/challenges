// Loop3.cpp : Lab Loop 3
// Isonyx
// COP 2272C-01 Programming I
// Last Successful Debug: 9/30/2015

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	int CONSTANT;
	int set = 2;
	int lineNumber;
	bool even = false;

	cout << "How many lines of tri-force would you like to create? ";
	cin >> lineNumber;

	CONSTANT = ((lineNumber / 2) + 2);

	if ((lineNumber % 2) == 0) {
		even = true;
		set = 3;
	}

	for (int a = 1; a <= lineNumber; a++) {
		cout << a << ". ";

		//Decrement Stage
		if (a >= CONSTANT) {
			for (int b = (a - set); b > 0; b--) {
				cout << "+";
			}
			set = set + 2;
		}

		//Maintain Equilibrium Stage
		else if ((a == (CONSTANT + 1)) && even) {
			for (int c = 0; c < (a - 1); c++) {
				cout << "+";
			}
		}

		//Increment Stage
		else {
			for (int d = 0; d < a; d++) {
				cout << "+";
			}
		}
		cout << endl;
	}

	cin >> lineNumber;
}
