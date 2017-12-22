"""
====================================
Create a plot of NEXRAD reflectivity
====================================

An example which creates a plot containing the first collected scan from a
NEXRAD file.

"""
print(__doc__)

# Author: Jonathan J. Helmus (jhelmus@anl.gov)
# License: BSD 3 clause

import matplotlib.pyplot as plt
import pyart

# open the file, create the displays and figure
#filename = './RCWF_20170614/2017_0614/2C_CS.vol/2017061400044400dBZ.vol'
#filename = './RCWF_20170614/2017_0614/2C_CDD.vol/2017061400050400dBZ.vol'
filename = './RCWF_20071006/2007_1006/20071006_0002_RCWF_VOL.000'
radar = pyart.io.read_nexrad_archive(filename)
print(radar.get_field(0,'reflectivity').shape)
display = pyart.graph.RadarDisplay(radar)
fig = plt.figure(figsize=(6, 5))

# plot super resolution reflectivity
ax = fig.add_subplot(111)
display.plot('reflectivity', 0, title='NEXRAD Reflectivity',
             vmin=-32, vmax=64, colorbar_label='', ax=ax)
display.plot_range_ring(radar.range['data'][-1]/1000., ax=ax)
display.set_limits(xlim=(-500, 500), ylim=(-500, 500), ax=ax)
plt.show()
