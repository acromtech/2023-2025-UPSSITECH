#ifndef COORDGPS_H
#define COORDGPS_H

#include <iostream>
#include <string>

class CoordGPS {
    float latitude, longitude;

public:
    CoordGPS(float lat = 0.0, float lon = 0.0);
    float getLatitude() const;   // Ajout des accesseurs en lecture
    float getLongitude() const;  // Ajout des accesseurs en lecture
    void afficher() const;
};

#endif // COORDGPS_H
