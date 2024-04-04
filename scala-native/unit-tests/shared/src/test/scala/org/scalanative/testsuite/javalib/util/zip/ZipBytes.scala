package org.scalanative.testsuite.javalib.util.zip

import java.util.zip._
import java.io.File
import java.nio.file.Files

// This object contains the bytes of all the files that are
// used in Harmony's test suite.
object ZipBytes {

  def getFile(bs: Array[Byte]): File = {
    val path = Files.createTempFile("zipFile", ".zip")
    Files.write(path, bs)
    path.toFile
  }

  def getZipFile(bs: Array[Byte]): ZipFile =
    new ZipFile(getFile(bs))

  def zipFile: Array[Byte] =
    Array[Byte](80, 75, 3, 4, 10, 0, 0, 0, 0, 0, -125, -118, -71, 38, 27, 67,
      -125, -5, 12, 0, 0, 0, 12, 0, 0, 0, 9, 0, 0, 0, 70, 105, 108, 101, 49, 46,
      116, 120, 116, 84, 104, 105, 115, 32, 105, 115, 32, 116, 101, 120, 116,
      80, 75, 3, 4, 10, 0, 0, 0, 0, 0, -119, -118, -71, 38, -102, -42, -120, 5,
      17, 0, 0, 0, 17, 0, 0, 0, 9, 0, 0, 0, 70, 105, 108, 101, 50, 46, 116, 120,
      116, 84, 104, 105, 115, 32, 105, 115, 32, 97, 108, 115, 111, 32, 116, 101,
      120, 116, 80, 75, 3, 4, 20, 0, 0, 0, 8, 0, -76, -118, -71, 38, -2, -82,
      -78, -90, 21, 0, 0, 0, 87, 16, 0, 0, 9, 0, 0, 0, 70, 105, 108, 101, 51,
      46, 116, 120, 116, -19, -64, -63, 0, 0, 0, 0, 3, 33, -66, -15, 19, -99,
      -61, -34, 53, 0, 0, 0, -128, 79, 80, 75, 3, 4, 10, 0, 0, 0, 0, 0, 111,
      110, -99, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 113, 0, 116, 101,
      115, 116, 100, 105, 114, 49, 47, 83, 68, 92, 0, -108, 0, 0, 0, 0, 8, 0,
      -90, -24, -63, -89, 99, 100, 96, 105, 16, 97, 96, 96, 48, 96, -128, 0, 31,
      32, 102, 100, 5, 51, 89, 69, -127, -60, 110, -82, 91, -126, 23, 111, -107,
      48, -77, 63, -75, -42, -2, -64, -116, 91, -114, -111, -119, -127, -127,
      -119, -63, -125, -127, 25, 36, -53, 44, -62, -16, -97, 81, -98, -127,
      -111, 17, -84, 22, 66, -94, -118, -79, 10, -127, -59, 36, 32, 98, 76, 16,
      49, 5, 32, -95, 0, 100, 3, 0, 85, 84, 13, 0, 7, 34, 116, 114, 66, 109,
      114, 118, 66, -9, 115, 114, 66, 80, 75, 3, 4, 10, 0, 0, 0, 0, 0, -125,
      -118, -71, 38, 27, 67, -125, -5, 12, 0, 0, 0, 12, 0, 0, 0, 18, 0, 111, 0,
      116, 101, 115, 116, 100, 105, 114, 49, 47, 70, 105, 108, 101, 49, 46, 116,
      120, 116, 83, 68, 90, 0, -108, 0, 0, 0, 0, 8, 0, -14, 117, -59, -23, 99,
      100, 96, 105, 16, 97, 96, 96, 48, 96, -128, 0, 31, 32, 102, 100, 5, 51,
      89, 69, -127, -60, 110, -82, 91, -126, 23, 111, -107, 48, -77, 63, -75,
      -42, -2, -64, -116, 91, -114, -111, -119, -127, -127, -119, -63, -125,
      -127, 25, 44, 45, -62, -16, -97, 81, -98, -127, -111, 17, -52, -127, -112,
      -88, 98, -84, 66, 96, 74, 2, 34, -58, 4, 17, 83, 0, 18, 10, 64, 54, 0, 85,
      84, 13, 0, 7, 6, 20, 75, 55, -100, 120, 118, 66, -3, 115, 114, 66, 84,
      104, 105, 115, 32, 105, 115, 32, 116, 101, 120, 116, 80, 75, 3, 4, 10, 0,
      0, 0, 0, 0, -119, -118, -71, 38, -102, -42, -120, 5, 17, 0, 0, 0, 17, 0,
      0, 0, 17, 0, 111, 0, 116, 101, 115, 116, 100, 105, 114, 49, 47, 116, 101,
      115, 116, 100, 105, 114, 49, 83, 68, 90, 0, -108, 0, 0, 0, 0, 8, 0, -14,
      117, -59, -23, 99, 100, 96, 105, 16, 97, 96, 96, 48, 96, -128, 0, 31, 32,
      102, 100, 5, 51, 89, 69, -127, -60, 110, -82, 91, -126, 23, 111, -107, 48,
      -77, 63, -75, -42, -2, -64, -116, 91, -114, -111, -119, -127, -127, -119,
      -63, -125, -127, 25, 44, 45, -62, -16, -97, 81, -98, -127, -111, 17, -52,
      -127, -112, -88, 98, -84, 66, 96, 74, 2, 34, -58, 4, 17, 83, 0, 18, 10,
      64, 54, 0, 85, 84, 13, 0, 7, 18, 20, 75, 55, -100, 120, 118, 66, 34, 116,
      114, 66, 84, 104, 105, 115, 32, 105, 115, 32, 97, 108, 115, 111, 32, 116,
      101, 120, 116, 80, 75, 1, 2, 20, 0, 10, 0, 0, 0, 0, 0, -125, -118, -71,
      38, 27, 67, -125, -5, 12, 0, 0, 0, 12, 0, 0, 0, 9, 0, 0, 0, 17, 0, 0, 0,
      1, 0, 32, 0, 0, 0, 0, 0, 0, 0, 70, 105, 108, 101, 49, 46, 116, 120, 116,
      84, 104, 105, 115, 32, 105, 115, 32, 70, 105, 108, 101, 49, 46, 116, 120,
      116, 80, 75, 1, 2, 20, 0, 10, 0, 0, 0, 0, 0, -119, -118, -71, 38, -102,
      -42, -120, 5, 17, 0, 0, 0, 17, 0, 0, 0, 9, 0, 0, 0, 17, 0, 0, 0, 1, 0, 32,
      0, 0, 0, 51, 0, 0, 0, 70, 105, 108, 101, 50, 46, 116, 120, 116, 84, 104,
      105, 115, 32, 105, 115, 32, 70, 105, 108, 101, 50, 46, 116, 120, 116, 80,
      75, 1, 2, 20, 0, 20, 0, 0, 0, 8, 0, -76, -118, -71, 38, -2, -82, -78, -90,
      21, 0, 0, 0, 87, 16, 0, 0, 9, 0, 0, 0, 17, 0, 0, 0, 1, 0, 32, 0, 0, 0,
      107, 0, 0, 0, 70, 105, 108, 101, 51, 46, 116, 120, 116, 84, 104, 105, 115,
      32, 105, 115, 32, 70, 105, 108, 101, 51, 46, 116, 120, 116, 80, 75, 1, 2,
      23, 11, 10, 0, 0, 0, 0, 0, 111, 110, -99, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 9, 0, 17, 0, 0, 0, 0, 0, 0, 0, 16, 0, -1, 65, -89, 0, 0, 0, 116,
      101, 115, 116, 100, 105, 114, 49, 47, 83, 68, 4, 0, -108, 0, 0, 0, 85, 84,
      5, 0, 7, 34, 116, 114, 66, 80, 75, 1, 2, 23, 11, 10, 0, 0, 0, 0, 0, -125,
      -118, -71, 38, 27, 67, -125, -5, 12, 0, 0, 0, 12, 0, 0, 0, 18, 0, 17, 0,
      0, 0, 0, 0, 1, 0, 32, 0, -74, -127, 63, 1, 0, 0, 116, 101, 115, 116, 100,
      105, 114, 49, 47, 70, 105, 108, 101, 49, 46, 116, 120, 116, 83, 68, 4, 0,
      -108, 0, 0, 0, 85, 84, 5, 0, 7, 6, 20, 75, 55, 80, 75, 1, 2, 23, 11, 10,
      0, 0, 0, 0, 0, -119, -118, -71, 38, -102, -42, -120, 5, 17, 0, 0, 0, 17,
      0, 0, 0, 17, 0, 17, 0, 0, 0, 0, 0, 1, 0, 32, 0, -74, -127, -22, 1, 0, 0,
      116, 101, 115, 116, 100, 105, 114, 49, 47, 116, 101, 115, 116, 100, 105,
      114, 49, 83, 68, 4, 0, -108, 0, 0, 0, 85, 84, 5, 0, 7, 18, 20, 75, 55, 80,
      75, 5, 6, 0, 0, 0, 0, 6, 0, 6, 0, -63, 1, 0, 0, -103, 2, 0, 0, 0, 0)

  val brokenManifestBytes =
    Array[Byte](80, 75, 3, 4, 20, 0, 8, 0, 8, 0, 58, 125, 37, 52, 0, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 9, 0, 4, 0, 77, 69, 84, 65, 45, 73, 78, 70, 47, -2,
      -54, 0, 0, 3, 0, 80, 75, 7, 8, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 80, 75,
      3, 4, 20, 0, 8, 0, 8, 0, 59, 125, 37, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 20, 0, 0, 0, 77, 69, 84, 65, 45, 73, 78, 70, 47, 77, 65, 78, 73, 70,
      69, 83, 84, 46, 77, 70, 0, 77, -52, -53, 76, 75, 45, 46, -47, 13, 75, 45,
      42, -50, -52, -49, -77, 82, 48, -44, 51, -32, -27, 114, 46, 74, 77, 44,
      73, 77, -47, 117, -86, 4, 9, -104, -24, 25, 41, 104, 120, 58, -7, 42, 56,
      -25, 23, 21, -28, 23, 37, -106, 0, 21, 106, -14, 114, -15, 114, 1, 0, 80,
      75, 7, 8, 10, -42, -53, -62, 61, 0, 0, 0, 62, 0, 0, 0, 80, 75, 3, 4, 20,
      0, 8, 0, 8, 0, 112, -104, -61, 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8,
      0, 0, 0, 66, 108, 97, 104, 46, 116, 120, 116, 115, -54, 73, -52, 0, 0, 80,
      75, 7, 8, 98, -50, 27, 110, 6, 0, 0, 0, 4, 0, 0, 0, 80, 75, 3, 4, 10, 0,
      0, 0, 0, 0, 55, 125, 37, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0,
      0, 102, 111, 111, 47, 80, 75, 3, 4, 10, 0, 0, 0, 0, 0, 55, 125, 37, 52, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 102, 111, 111, 47, 98, 97,
      114, 47, 80, 75, 3, 4, 20, 0, 8, 0, 8, 0, -122, 116, 37, 52, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 102, 111, 111, 47, 98, 97, 114, 47,
      65, 46, 99, 108, 97, 115, 115, 101, 0, -51, 106, -62, 64, 20, -123, -49,
      -43, 105, 98, -90, -15, -89, -126, 15, -32, -50, -90, 96, 30, -96, -91,
      32, -126, 43, 105, 23, 22, -9, 19, -99, -54, -120, 77, 32, -115, 125, -81,
      46, -118, -48, -123, 15, -32, 67, -107, -98, 9, -126, 11, 23, 115, -26,
      -50, -71, -33, -103, 123, 79, 127, -65, 71, 0, 99, -12, 53, 20, 58, 17,
      -102, -24, -122, -24, -123, -72, 19, -56, -89, -96, 63, -33, -102, 47,
      -109, -18, 76, -66, 73, 23, 85, -23, -14, -51, -93, 32, 120, 114, -71,
      -85, -98, 5, -51, -47, -3, 82, -96, -90, -59, -38, 10, -70, 115, -105,
      -37, -105, -3, 71, 102, -53, 55, -109, -19, -24, 12, 70, -41, 105, 31,
      -48, -117, 98, 95, -82, -20, -52, 121, 40, -104, -116, 61, 20, 35, 68, 43,
      -58, 13, 2, 65, -12, 94, 20, 105, 102, -54, 116, 34, -24, 93, 126, 120,
      -51, -74, 118, 85, 97, -56, 29, 21, 119, 22, 30, -30, -44, 6, 107, -90,
      -87, 17, 95, 67, -34, 117, 47, 57, 64, -66, 107, 80, 83, 53, 49, 16, 83,
      53, 24, -30, -10, -116, 39, -12, 125, 71, 123, 60, 121, -8, 65, -29, -110,
      -23, 112, -108, 79, 42, -46, 17, 98, -70, 113, 61, -82, -3, 15, 80, 75, 7,
      8, 123, 50, 61, -108, -31, 0, 0, 0, 55, 1, 0, 0, 80, 75, 1, 2, 20, 0, 20,
      0, 8, 0, 8, 0, 58, 125, 37, 52, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 9, 0,
      4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 69, 84, 65, 45, 73,
      78, 70, 47, -2, -54, 0, 0, 80, 75, 1, 2, 20, 0, 20, 0, 8, 0, 8, 0, 59,
      125, 37, 52, 10, -42, -53, -62, 61, 0, 0, 0, 62, 0, 0, 0, 20, 0, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 61, 0, 0, 0, 77, 69, 84, 65, 45, 73, 78, 70,
      47, 77, 65, 78, 73, 70, 69, 83, 84, 46, 77, 70, 80, 75, 1, 2, 20, 0, 20,
      0, 8, 0, 8, 0, 112, -104, -61, 38, 98, -50, 27, 110, 6, 0, 0, 0, 4, 0, 0,
      0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -68, 0, 0, 0, 66, 108, 97,
      104, 46, 116, 120, 116, 80, 75, 1, 2, 10, 0, 10, 0, 0, 0, 0, 0, 55, 125,
      37, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0, -8, 0, 0, 0, 102, 111, 111, 47, 80, 75, 1, 2, 10, 0, 10, 0, 0,
      0, 0, 0, 55, 125, 37, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0,
      0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 1, 0, 0, 102, 111, 111, 47, 98, 97, 114,
      47, 80, 75, 1, 2, 20, 0, 20, 0, 8, 0, 8, 0, -122, 116, 37, 52, 123, 50,
      61, -108, -31, 0, 0, 0, 55, 1, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 64, 1, 0, 0, 102, 111, 111, 47, 98, 97, 114, 47, 65, 46, 99, 108,
      97, 115, 115, 80, 75, 5, 6, 0, 0, 0, 0, 6, 0, 6, 0, 88, 1, 0, 0, 94, 2, 0,
      0, 0, 0)
}
