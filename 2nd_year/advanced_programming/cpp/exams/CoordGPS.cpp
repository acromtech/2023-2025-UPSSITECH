#include "CoordGPS.h"

CoordGPS::CoordGPS(float lat, float lon) : latitude(lat), longitude(lon) {
}

float CoordGPS::getLatitude() const {
    return latitude;
}

float CoordGPS::getLongitude() const {
    return longitude;
}

void CoordGPS::afficher() const {
    std::cout << "Latitude: " << latitude << ", Longitude: " << longitude << std::endl;
}
