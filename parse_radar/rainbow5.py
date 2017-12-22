import wradlib as wrl
import matplotlib.pyplot as pl
import numpy as np

filename = "./2017_0614/2017061400004100dBZ.vol"
# "./2016_0601/2016060100034200dBZ.vol"
rbdict = wrl.io.read_Rainbow(filename)
numele = int(rbdict['volume']['scan']['pargroup']['numele'])
#print('Available Level '+str(numele))
slices = rbdict['volume']['scan']['slice']

lon = float(rbdict['volume']['radarinfo']['@lon'])
lat = float(rbdict['volume']['radarinfo']['@lat'])

azires = float(slices[0]['anglestep'])
stoprange = float(slices[0]['stoprange'])
# iterate over available slices
for nofslice in range(numele):
   print('Draw sweep: '+str(nofslice))
   azi = slices[nofslice]['slicedata']['rayinfo']['data']
   azidepth = float(slices[nofslice]['slicedata']['rayinfo']['@depth'])
   azirange = float(slices[nofslice]['slicedata']['rayinfo']['@rays'])
   azi = (azi * azirange / 2**azidepth) * azires

   
   rangestep = float(slices[nofslice]['rangestep'])
   r = np.arange(0, stoprange, rangestep)

   data = slices[nofslice]['slicedata']['rawdata']['data']
   datadepth = float(slices[nofslice]['slicedata']['rawdata']['@depth'])
   datamin = float(slices[nofslice]['slicedata']['rawdata']['@min'])
   datamax = float(slices[nofslice]['slicedata']['rawdata']['@max'])
   data = datamin + data * (datamax - datamin) / 2 ** datadepth
   #np.set_printoptions(threshold=np.inf)
   #print(data.shape)

   unit = slices[nofslice]['slicedata']['rawdata']['@type']
   time = slices[nofslice]['slicedata']['@time']
   date = slices[nofslice]['slicedata']['@date']
   posangle = slices[nofslice]['posangle']
   sensortype = rbdict['volume']['radarinfo']['@id']
   sensorname = rbdict['volume']['radarinfo']['name']

   fig = pl.figure(figsize=(8,8))
   cgax, pm = wrl.vis.plot_ppi(np.ma.masked_less(data,-30), r=r, az=azi, fig=fig, cg=True, vmin=-10, vmax=60)

   title = '{0} {1} {2} {3}\n {4} {5}'.format(sensortype, sensorname, date,
                                                time, 'angle=', posangle)
   caax = cgax.parasites[0]
   t = pl.title(title, fontsize=12)
   t.set_y(1.1)
   cbar = pl.gcf().colorbar(pm, pad=0.075)
   caax.set_xlabel('x_range [km]')
   caax.set_ylabel('y_range [km]')
   pl.text(1.0, 1.05, 'azimuth', transform=caax.transAxes, va='bottom',
                 ha='right')
   cbar.set_label('reflectivity [' + unit + ']')
   #pl.show()
   #pl.savefig(date+'-'+time+'-'+str(nofslice)+'.png')
   pl.savefig(date+'-'+str(nofslice)+'.png')
